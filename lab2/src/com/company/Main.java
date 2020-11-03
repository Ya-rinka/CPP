package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Map<String, List<FootballClub>> footballClubsMap = new HashMap<String, List<FootballClub>>();

        boolean exit = false;

        while (!exit) {
            System.out.print("\nChoose action:" +
                    "\n1 - print n clubs from the list" +
                    "\n2 - check how many cities have common names of clubs" +
                    "\n3 - read data from 2 files and merge them" +
                    "\nYour choise: ");
            Scanner myInput = new Scanner(System.in);
            int option = (int) myInput.nextInt();
            switch (option) {
                case 1:
                    System.out.print("How much clubs do you want to print?" +
                            "\nYour choise: ");
                    int n = (int) myInput.nextInt();
                    System.out.print("\nMap of clubs(city is key):\n\n");
                    footballClubsMap = FootballClubMap.ReadFromOneFile();
                    FootballClubMap.PrintOutputMap(footballClubsMap, n);
                    break;
                case 2:
                    footballClubsMap = FootballClubMap.ReadFromOneFile();
                    System.out.println("Number of cities, which have common names of clubs: " + FootballClubMap.CitiesWithSameClubs(footballClubsMap));
                    System.out.println();
                    break;
                case 3:

                    System.out.println("Select the output:" +
                            "\n1 - print all from two files" +
                            "\n2 - print only common from two files" +
                            "\nYour choise: ");
                    int outputNum = (int) myInput.nextInt();
                    footballClubsMap = FootballClubMap.ReadFromTwoFiles(outputNum);
                    FootballClubMap.PrintOutputMap(footballClubsMap);
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }
}