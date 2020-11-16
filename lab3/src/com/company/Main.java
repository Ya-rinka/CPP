package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Task 1:\n\n");

        String text_1 = readFile("D:\\study\\course3\\sem1\\CPP_files\\lab3\\text1.txt");
        doTask1(text_1);

        String text_2 = readFile("D:\\study\\course3\\sem1\\CPP_files\\lab3\\text2.txt");
        doTask1(text_2);


        System.out.println("\n\nTask2:\n");
        String text = readFile("D:\\study\\course3\\sem1\\CPP_files\\lab3\\text1.txt");
        doTask2(text);

    }

    public static void doTask1(String text1) {
        Scanner textScanner = new Scanner(text1);
        List<String> sentences = new LinkedList<>();
        textScanner.useDelimiter("\\. |\\? |! |\\n");

        Task1 task1 = new Task1();

        while(textScanner.hasNext()){
            sentences.add(textScanner.next());
        }

        System.out.println("\nFile:\n" + sentences + "\n");

        task1.deleteLongSentence(sentences);

        System.out.println("\nPossible paths:");

        for(String s : sentences){
            if (task1.findPossiblePaths(s) != null){
                System.out.println(task1.findPossiblePaths(s));
            }
        }

    }

    public static void doTask2(String text) {
        Task2 task = new Task2();
        List<String> listOfQuestions = task.findQuestions(text);

        System.out.print("Enter the length of words to search\n> ");

        Scanner myInput = new Scanner(System.in);
        int wordLength = myInput.nextInt();

        for (String s : listOfQuestions){
            System.out.println(s);

            List<String> words = task.findWordsWithSizeGiven(s, wordLength);

            if (words.size() > 0) {
                System.out.println("Found words:");
                for (String w : words){
                    System.out.println(" " + w);
                }
            }
            else{
                System.out.println("---Words with such length are not in the file.---");
            }
        }
    }

    public static String readFile(String filename) throws FileNotFoundException{

        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        String text = new String();
        fileScanner.useDelimiter("\\Z");
        text = fileScanner.next();

        return text;
    }
}










