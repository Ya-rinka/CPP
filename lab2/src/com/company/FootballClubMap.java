package com.company;
import java.io.File;
import java.util.*;

public class FootballClubMap {

    public static Map<String, List<FootballClub>> PutDataToMap(List<FootballClub> footballClubList) {
        Map<String, List<FootballClub>> map = new TreeMap<>();

        for (FootballClub club: footballClubList) {
            if (!map.containsKey(club.getCity())) {
                map.put(club.getCity(), new LinkedList<>());
            }
            map.get(club.getCity()).add(club);
        }

        return map;
    }

    public static List<FootballClub> FindSameItems(List<FootballClub> list1, List<FootballClub> list2){
        List<FootballClub> list = new LinkedList<>();

        for (FootballClub club : list1){
            if(list2.contains(club)){
                list.add(club);
            }
        }

        return list;
    }

    public static int CitiesWithSameClubs(Map<String, List<FootballClub>> map){

        Set<String> citiesWithSameClubs = new TreeSet<>();
        String[] keySet = new String[map.size()];
        map.keySet().toArray(keySet);

        for (int i = 0; i < keySet.length; ++i){
            for (int j = i; j < keySet.length; ++j){
                if(i == j){
                    continue;
                }
                List<FootballClub> clubs = FindSameItems(map.get(keySet[i]), map.get(keySet[j]));

                if(!clubs.isEmpty()){
                    citiesWithSameClubs.add(keySet[i]);
                    citiesWithSameClubs.add(keySet[j]);
                }
            }
        }
        System.out.println("\nCities, which have common names of clubs: " + citiesWithSameClubs);
        return citiesWithSameClubs.size();
    }

    private static void ReadFile(List<FootballClub> footballClubs, String fileName) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while(myReader.hasNextLine()){
                String name = myReader.next();
                String year = myReader.next();
                String city = myReader.next();

                footballClubs.add(new FootballClub(name, Integer.parseInt(year), city));
            }
            myReader.close();
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    public static Map<String, List<FootballClub>> ReadFromOneFile()
    {
        Map<String, List<FootballClub>> map = new TreeMap<>();
        List<FootballClub> footballClubs = new LinkedList<>() {
        };

        String fileName = "D:\\clubs.txt";
        ReadFile(footballClubs, fileName);
        map = PutDataToMap(footballClubs);

        return map;
    }

    public static Map<String, List<FootballClub>> ReadFromTwoFiles(int outputNum)
    {
        Map<String, List<FootballClub>> map1 = new TreeMap<>();
        Map<String, List<FootballClub>> map2 = new TreeMap<>();
        List<FootballClub> footballClubs1 = new LinkedList<>() {};
        List<FootballClub> footballClubs2 = new LinkedList<>() {};

        String fileName1 = "D:\\clubs.txt";
        String fileName2 = "D:\\clubs2.txt";

        ReadFile(footballClubs1, fileName1);
        ReadFile(footballClubs2, fileName2);
        map1 = PutDataToMap(footballClubs1);
        map2 = PutDataToMap(footballClubs2);

        switch (outputNum){
            case 1:
                return JointTwoMaps(map1, map2);
            case 2:
                return FindSameClubsInMaps(map1, map2);
        }
        return JointTwoMaps(map1, map2);
    }


    public static Map<String, List<FootballClub>> JointTwoMaps(Map<String, List<FootballClub>> map1,
                                                               Map<String, List<FootballClub>> map2){
        Map<String, List<FootballClub>> map = new TreeMap<>(map1);

        for(String key : map2.keySet()){
            if(!map.containsKey(key)){
                map.put(key, map2.get(key));
            }
            else{
                for (FootballClub club : map2.get(key)){
                    if(!map.get(key).contains(club)){
                        map.get(key).add(club);
                    }
                }
            }
        }

        return map;
    }

    public static Map<String, List<FootballClub>> FindSameClubsInMaps(Map<String, List<FootballClub>> map1,
                                                                      Map<String, List<FootballClub>> map2){
        Map<String, List<FootballClub>> map = new TreeMap<>();

        for(String key : map1.keySet()){
            if(map2.containsKey(key) && !FindSameItems(map1.get(key), map2.get(key)).isEmpty()){
                map.put(key, FindSameItems(map1.get(key), map2.get(key)));
            }
        }

        return map;
    }


    public static void PrintOutputMap(Map<String, List<FootballClub>> map) {
        for (String key : map.keySet()) {
            System.out.println("\nCity(KEY):" + key);
            for (FootballClub club : map.get(key)) {
                System.out.println("Name: " + club.getName() + ", year: " + club.getYear());
            }
        }
    }

    public static void PrintOutputMap(Map<String, List<FootballClub>> map, int n) {

        for (String key : map.keySet()) {
            int i = 0;
            System.out.println("\nCity(KEY): " + key);
            for (FootballClub club : map.get(key)) {
                i++;
                if (i <= n) {
                    System.out.println("Name: " + club.getName() + ", year: " + club.getYear());
                }
            }
        }
    }

}
