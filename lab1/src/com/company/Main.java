package com.company;

import com.company.Menu.PriceComparator;
import com.company.Menu.WeightComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Hello! Our restaurant congrats you! \nHow can we call you?");
        Scanner in = new Scanner(System.in);
        String customerName = in.nextLine();
        Customer customer = new Customer(customerName, 1);
        System.out.println("Thanks, " + customer.name + "! Would you like to watch our menu? (1 - yes, 0 - no)");
        int choise = in.nextInt();
        if (choise == 1) {
            System.out.println("1 - common menu, \n2 - vegeterian menu,\n3 - kids menu,\n4 - alcohol menu");
            int menuCategory = in.nextInt();
            ArrayList alcoholDishes;
            Menu alcoholMenu;
            Scanner in1;
            String searchName;
            ArrayList foundDishes;
            int alcoMenuSortType;
            WeightComparator weightComparator;
            PriceComparator priceComparator;
            switch(menuCategory) {
                case 1:
                    alcoholDishes = new ArrayList();
                    alcoholMenu = new Menu(alcoholDishes);
                    alcoholMenu.category = Category.COMMON;
                    alcoholDishes.add(new Meal("Pigmeat", "very good meal", 150, 400));
                    alcoholDishes.add(new Meal("Chicken", "very good too))", 100, 300));
                    alcoholDishes.add(new Meal("Chicken", "very good too))", 120, 320));
                    alcoholDishes.add(new Meal("Chicken", "very good too))", 110, 280));
                    alcoholDishes.add(new Meal("Chicken", "very good too))", 140, 400));
                    alcoholDishes.add(new Meal("Chicken", "very good too))", 80, 210));
                    alcoholDishes.add(new Meal("Borshch", "very good too))", 40, 200));
                    alcoholDishes.add(new Meal("Varenyk", "very good too))", 60, 270));
                    alcoholDishes.add(new Meal("Grechka", "very good too))", 40, 200));
                    System.out.println("Your menu:\nNAME\t\tDESCRIPTION\t\t\tPRICE\t\tWEIGHT\t");
                    alcoholMenu.output(alcoholDishes);
                    System.out.println("\nPlease, write a name of the meal, which you want to find:");
                    in1 = new Scanner(System.in);
                    searchName = in1.nextLine();
                    foundDishes = new ArrayList();
                    alcoholMenu.searchByName(searchName, alcoholDishes, foundDishes);
                    System.out.println("\nThanks for watching! Also you can:\n1 - Sort by price in ascending order\n2 - Sort by price in descending order\n3 - Sort by weight in ascending order\n4 - Sort by weight in descending order");
                    alcoMenuSortType = in.nextInt();
                    switch(alcoMenuSortType) {
                        case 1:
                            Objects.requireNonNull(alcoholMenu);
                            priceComparator = new PriceComparator();
                            Collections.sort(foundDishes, priceComparator);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 2:
                            alcoholMenu.sortWithAnonClass(foundDishes);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 3:
                            weightComparator = new WeightComparator();
                            Collections.sort(foundDishes, weightComparator);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 4:
                            alcoholMenu.sortWithLambda(foundDishes);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 5:
                            System.out.println("Ohh, wrong input! Please, choose 1 ( to sort by price) or 2 (to sort by weight)...pererobyty");
                            return;
                        default:
                            return;
                    }
                case 2:
                    alcoholDishes = new ArrayList();
                    alcoholMenu = new Menu(alcoholDishes);
                    alcoholMenu.category = Category.VEGETERIAN;
                    alcoholDishes.add(new Meal("Plate of vegetables", "very good meal", 70, 250));
                    alcoholDishes.add(new Meal("Salad with tomatoes", "very good too))", 80, 230));
                    alcoholDishes.add(new Meal("Salad with tomatoes", "very good too))", 80, 270));
                    alcoholDishes.add(new Meal("Salad with tomatoes", "very good too))", 90, 220));
                    alcoholDishes.add(new Meal("Salad with tomatoes", "very good too))", 70, 260));
                    alcoholDishes.add(new Meal("Salad with tomatoes", "very good too))", 60, 290));
                    alcoholDishes.add(new Meal("Cezar w feta cheese", "very good too))", 100, 260));
                    alcoholDishes.add(new Meal("Vegeterian new meat", "very good too))", 95, 240));
                    alcoholDishes.add(new Meal("Vegan soup w greens", "very good too))", 40, 180));
                    System.out.println("Your menu:\nNAME\t\t\t\tDESCRIPTION\t\t\tPRICE\t\tWEIGHT\t");
                    alcoholMenu.output(alcoholDishes);
                    System.out.println("\nPlease, write a name of the meal, which you want to find:");
                    in1 = new Scanner(System.in);
                    searchName = in1.nextLine();
                    foundDishes = new ArrayList();
                    alcoholMenu.searchByName(searchName, alcoholDishes, foundDishes);
                    System.out.println("\nThanks for watching! Also you can:\n1 - Sort by price in ascending order\n2 - Sort by price in descending order\n3 - Sort by weight in ascending order\n4 - Sort by weight in descending order");
                    alcoMenuSortType = in.nextInt();
                    switch(alcoMenuSortType) {
                        case 1:
                            Objects.requireNonNull(alcoholMenu);
                            priceComparator = new PriceComparator();
                            Collections.sort(foundDishes, priceComparator);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 2:
                            alcoholMenu.sortWithAnonClass(foundDishes);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 3:
                            weightComparator = new WeightComparator();
                            Collections.sort(foundDishes, weightComparator);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 4:
                            alcoholMenu.sortWithLambda(foundDishes);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 5:
                            System.out.println("Ohh, wrong input! Please, choose 1 ( to sort by price) or 2 (to sort by weight)...pererobyty");
                            return;
                        default:
                            return;
                    }
                case 3:
                    alcoholDishes = new ArrayList();
                    alcoholMenu = new Menu(alcoholDishes);
                    alcoholMenu.category = Category.KIDS;
                    alcoholDishes.add(new Meal("Pizza w cheese", "very good meal", 120, 400));
                    alcoholDishes.add(new Meal("Pizza w cheese", "very good meal", 100, 370));
                    alcoholDishes.add(new Meal("Pizza w cheese", "very good meal", 130, 410));
                    alcoholDishes.add(new Meal("Pizza w cheese", "very good meal", 90, 250));
                    alcoholDishes.add(new Meal("Pizza w cheese", "very good meal", 150, 390));
                    alcoholDishes.add(new Meal("Burgers w meat", "very good too))", 90, 300));
                    alcoholDishes.add(new Meal("Mashed potatos", "very good too))", 50, 250));
                    alcoholDishes.add(new Meal("Chicken chopss", "very good too))", 100, 300));
                    alcoholDishes.add(new Meal("Banana pancake", "very good too))", 70, 270));
                    System.out.println("Your menu:\nNAME\t\t\t\tDESCRIPTION\t\t\tPRICE\t\tWEIGHT\t");
                    alcoholMenu.output(alcoholDishes);
                    System.out.println("\nPlease, write a name of the meal, which you want to find:");
                    in1 = new Scanner(System.in);
                    searchName = in1.nextLine();
                    foundDishes = new ArrayList();
                    alcoholMenu.searchByName(searchName, alcoholDishes, foundDishes);
                    System.out.println("\nThanks for watching! Also you can:\n1 - Sort by price in ascending order\n2 - Sort by price in descending order\n3 - Sort by weight in ascending order\n4 - Sort by weight in descending order");
                    alcoMenuSortType = in.nextInt();
                    switch(alcoMenuSortType) {
                        case 1:
                            Objects.requireNonNull(alcoholMenu);
                            priceComparator = new PriceComparator();
                            Collections.sort(foundDishes, priceComparator);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 2:
                            alcoholMenu.sortWithAnonClass(foundDishes);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 3:
                            weightComparator = new WeightComparator();
                            Collections.sort(foundDishes, weightComparator);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 4:
                            alcoholMenu.sortWithLambda(foundDishes);
                            alcoholMenu.output(foundDishes);
                            return;
                        case 5:
                            System.out.println("Ohh, wrong input! Please, choose 1 ( to sort by price) or 2 (to sort by weight)...pererobyty");
                            return;
                        default:
                            return;
                    }
                case 4:
                    alcoholDishes = new ArrayList();
                    alcoholMenu = new Menu(alcoholDishes);
                    alcoholMenu.category = Category.ALCOHOL;
                    alcoholDishes.add(new Meal("Russian Vodka)", "very good meal", 40, 50));
                    alcoholDishes.add(new Meal("Dry pink vinee", "very good too))", 120, 150));
                    alcoholDishes.add(new Meal("Dry white vine", "very good too))", 120, 150));
                    alcoholDishes.add(new Meal("Stella Artoise", "very good too))", 50, 500));
                    alcoholDishes.add(new Meal("Carlsberg beer", "very good too))", 45, 550));
                    alcoholDishes.add(new Meal("Carlsberg beer", "very good too))", 40, 500));
                    alcoholDishes.add(new Meal("Carlsberg beer", "very good too))", 35, 450));
                    alcoholDishes.add(new Meal("Carlsberg beer", "very good too))", 50, 450));
                    alcoholDishes.add(new Meal("Carlsberg beer", "very good too))", 45, 600));
                    System.out.println("Your menu:\nNAME\t\t\t\tDESCRIPTION\t\t\tPRICE\t\tWEIGHT\t");
                    alcoholMenu.output(alcoholDishes);
                    System.out.println("\nPlease, write a name of the meal, which you want to find:");
                    in1 = new Scanner(System.in);
                    searchName = in1.nextLine();
                    foundDishes = new ArrayList();
                    alcoholMenu.searchByName(searchName, alcoholDishes, foundDishes);
                    System.out.println("\nThanks for watching! Also you can:\n1 - Sort by price in ascending order\n2 - Sort by price in descending order\n3 - Sort by weight in ascending order\n4 - Sort by weight in descending order");
                    alcoMenuSortType = in.nextInt();
                    switch(alcoMenuSortType) {
                        case 1:
                            Objects.requireNonNull(alcoholMenu);
                            priceComparator = new PriceComparator();
                            Collections.sort(foundDishes, priceComparator);
                            alcoholMenu.output(foundDishes);
                            break;
                        case 2:
                            alcoholMenu.sortWithAnonClass(foundDishes);
                            alcoholMenu.output(foundDishes);
                            break;
                        case 3:
                            weightComparator = new WeightComparator();
                            Collections.sort(foundDishes, weightComparator);
                            alcoholMenu.output(foundDishes);
                            break;
                        case 4:
                            alcoholMenu.sortWithLambda(foundDishes);
                            alcoholMenu.output(foundDishes);
                            break;
                        case 5:
                            System.out.println("Ohh, wrong input! Please, choose 1 ( to sort by price) or 2 (to sort by weight)...pererobyty");
                    }
            }
        } else if (choise == 0) {
            System.out.println("Hmmmm,  maybe next time!");
        } else {
            System.out.println("Ohh, wrong input! Please, choose 1 ( to watch menu) or 0 (not to)");
        }

    }
}