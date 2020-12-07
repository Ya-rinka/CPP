package com.company;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
public class Primma {
    private Map<String, Map<String, Integer>> graph;
    List <Primma.Head> minHeads = new ArrayList<>();
    public static List<Thread> threads = new ArrayList<>();
    public static List<Thread> threadsFinal = new ArrayList<>();
    Primma(String path) {
        this.graph = new ConvertFile().getTreeToFile(path);
    }
    void setMinHeads (List <Primma.Head> minHeads)
    {
        this.minHeads = minHeads;
    }
    void addMinHeads (List <Primma.Head> minHeads)
    {
        this.minHeads.addAll(minHeads);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.graph != null && !this.graph.isEmpty()) {
            for (Map.Entry<String, Map<String, Integer>> entry : this.graph.entrySet()) {
                String v = entry.getKey();
                for (Map.Entry<String, Integer> value : entry.getValue().entrySet()) {
                    sb.append("V{").append(v).append(", ").append(value.getKey()).append("}; U{");
                    sb.append(value.getValue()).append("};").append("\n");
                }
            }
        }
        sb.append("\nFinal weight of the graph: ").append(getWeightGraph()).append(";");
        return sb.toString();
    }
    public int getWeightGraph() {
        int weight = 0;
        if (this.graph != null && !this.graph.isEmpty()) {
            for (Map<String, Integer> map : this.graph.values()) {
                for (Integer value : map.values()) {
                    weight += value;
                }
            }
        }
        return weight / 2;
    }
    private boolean isHead(String headName, List<String> names) {
        boolean result = names == null || names.isEmpty();
        if (!result) {
            for (String head : names) {
                if (head.equals(headName)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    private Head getMinU(List<String> list) {
        threads.clear();
        int min = Integer.MAX_VALUE;
        Head minV = null;
        if (this.graph != null && !this.graph.isEmpty()) {
            for (Map.Entry<String, Map<String, Integer>> entry : this.graph.entrySet()) {
                if (isHead(entry.getKey(), list)) {
                    threads.add(new MinUFinder(entry));
                }
            }
            threads.forEach(t -> {
                try {
                    t.start();
                    t.join(1000);
                } catch (Exception e) {
                    System.out.println("Interrupted");
                }
            });
            threads.clear();
            {
                minV = Collections.min(this.minHeads, Comparator.comparing(h -> h.valueU));
                minHeads.clear();
            }
        }
        return minV;
    }
    private class MinUFinder extends Thread {
        Head minVa = null;
        int min = Integer.MAX_VALUE;
        List <Primma.Head> Heads = new ArrayList<>();
        Map.Entry<String, Map<String, Integer>> entry;
        MinUFinder(Map.Entry<String, Map<String, Integer>> entry)
        {
            this.entry= entry;
        }
        void setEntry(Map.Entry<String, Map<String, Integer>> entry)
        {
            this.entry= entry;
        }
        public void run() {
            for (Map.Entry<String, Integer> value : entry.getValue().entrySet()) {
                if (value.getValue() < min) {
                    min = value.getValue();
                    minVa = new Primma.Head(entry.getKey(), value.getKey(), value.getValue());
                }
            }
            try {
                currentThread().join(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.Heads.add(minVa);
            addMinHeads(this.Heads);
        }
    }
    private void removePareV(String first, String second) {
        if (this.graph != null && !this.graph.isEmpty()) {
            Map<String, Integer> map;
            if (this.graph.containsKey(first)) {
                map = this.graph.get(first);
                if (map.containsKey(second)) {
                    map.remove(second);
                }
                if (map.isEmpty()) {
                    this.graph.remove(first);
                }
            }
            if (this.graph.containsKey(second)) {
                map = this.graph.get(second);
                if (map.containsKey(first)) {
                    map.remove(first);
                }
                if (map.isEmpty()) {
                    this.graph.remove(second);
                }
            }
        }
    }
    private void removeV(List<String> list) {
        if (list.size() > 2) {
            for (int index = 0; index < list.size() - 1; index++) {
                for (int indexSecond = index + 1; indexSecond < list.size(); indexSecond++) {
                    removePareV(list.get(index), list.get(indexSecond));
                }
            }
        }
    }
    public void prima()
    {
        Map<String, Map<String, Integer>> minTree = new TreeMap<>();
        List<String> listV = new ArrayList<>();
        Head min;
        while(!this.graph.isEmpty()) {
            min = getMinU(listV);
            if (min != null) {
                listV.add(min.firstV);
                listV.add(min.secondV);
                if (minTree.containsKey(min.firstV))
                {
                    minTree.get(min.firstV).put(min.secondV, min.valueU);
                    System.out.println(min.firstV + " -> " + min.secondV+ " (sum: " + min.valueU + ")");
                }
                else
                {
                    minTree.put(min.firstV, new TreeMap<>());
                    minTree.get(min.firstV).put(min.secondV, min.valueU);
                }
                if (minTree.containsKey(min.secondV))
                {
                    minTree.get(min.secondV).put(min.firstV, min.valueU);
                }
                else
                {
                    minTree.put(min.secondV, new TreeMap<>());
                    minTree.get(min.secondV).put(min.firstV, min.valueU);
                }
                removeV(listV);
            }
        }
        this.graph = minTree;
        System.out.println("\nFinal weight of the graph: "+ getWeightGraph());
    }
    private class Head implements Comparable<Head> {
        private String firstV;
        private String secondV;
        private Integer valueU;
        Head(String firstV, String secondV, Integer valueU) {
            this.firstV = firstV;
            this.secondV = secondV;
            this.valueU = valueU;
        }
        @Override
        public int compareTo(Head o) {
            return this.valueU - o.valueU;
        }
    }
    private class ConvertFile {
        private String[] readFile(String path) {
            String[] lines = null;
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                lines = stream.toArray(String[]::new);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        }
        private Map<String, Map<String, Integer>> getTreeToFile(String path) {
            Map<String, Map<String, Integer>> tree = new TreeMap<>();
            String[] lines = readFile(path);
            if (lines != null) {
                for (String line : lines) {
                    Node[] nodes = parseLineToNode(line);
                    if (nodes != null) {
                        for (Node node : nodes) {
                            Map<String, Integer> map;
                            if (tree.containsKey(node.first)) {
                                map = tree.get(node.first);
                                if (!map.containsKey(node.second)) {
                                    map.put(node.second, node.value);
                                }
                            } else {
                                tree.put(node.first, new TreeMap<>());
                                map = tree.get(node.first);
                                map.put(node.second, node.value);
                            }
                            if (tree.containsKey(node.second)) {
                                map = tree.get(node.second);
                                if (!map.containsKey(node.first)) {
                                    map.put(node.first, node.value);
                                }
                            } else {
                                tree.put(node.second, new TreeMap<>());
                                map = tree.get(node.second);
                                map.put(node.first, node.value);
                            }
                        }
                    }
                }
            }
            return tree;
        }
        private Node[] parseLineToNode(String line) {
            Node[] nodes = null;
            if (line != null) {
                String[] mainString = line.split("=");
                if (mainString.length == 2) {
                    String first = correctString(mainString[0]);
                    String[] elements = mainString[1].split(",");
                    if (elements.length > 0) {
                        nodes = new Node[elements.length];
                        int index = 0;
                        for (String element : elements) {
                            String[] weight = element.trim().split("\\s+");
                            if (weight.length == 2) {
                                nodes[index++] = new Node(first, weight[0],
                                        Integer.valueOf(weight[1]));
                            }
                        }
                    }
                }
            }
            return nodes;
        }
        private String correctString(String offer) {
            if (offer != null) {
                offer = offer.trim().toUpperCase();
                if (offer.length() > 1) {
                    offer = offer.substring(0, 1).concat(offer.substring(1,
                            offer.length()).toLowerCase());
                }
            }
            return offer;
        }
        private class Node {
            private final String first;
            private final String second;
            private final Integer value;
            Node(String first, String second, Integer value) {
                this.first = first;
                this.second = second;
                this.value = value;
            }
        }
    }
}
