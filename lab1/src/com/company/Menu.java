package com.company;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Menu {
    ArrayList<Meal> meals;
    Category category;

    Menu(ArrayList<Meal> m_meals) {
        this.meals = m_meals;
    }

    public void sortWithAnonClass(ArrayList<Meal> dishes) {
        Collections.sort(dishes, new Comparator<Meal>() {
            public int compare(Meal meal1, Meal meal2) {
                return meal2.getPrice() - meal1.getPrice();
            }
        });
    }

    public void sortWithLambda(ArrayList<Meal> dishes) {
        Collections.sort(dishes, (meal1, meal2) -> {
            return meal2.getWeight() - meal1.getWeight();
        });
    }

    public void output(ArrayList<Meal> dishes) {
        for(int i = 0; i < dishes.size(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = ((Meal)dishes.get(i)).getName();
            var10000.println(var10001 + "\t\t" + ((Meal)dishes.get(i)).getDescription() + "\t\t" + ((Meal)dishes.get(i)).getPrice() + "\t\t\t" + ((Meal)dishes.get(i)).getWeight() + "\t");
        }

    }

    public void searchByName(String name, ArrayList<Meal> dishes, ArrayList<Meal> foundDishes) {
        int i;
        for(i = 0; i < dishes.size(); ++i) {
            if (((Meal)dishes.get(i)).getName().equals(name)) {
                foundDishes.add((Meal)dishes.get(i));
            }
        }

        if (foundDishes.size() > 0) {
            System.out.println("Found!:");

            for(i = 0; i < foundDishes.size(); ++i) {
                PrintStream var10000 = System.out;
                String var10001 = ((Meal)foundDishes.get(i)).getName();
                var10000.println(var10001 + "\t\t" + ((Meal)foundDishes.get(i)).getDescription() + "\t\t" + ((Meal)foundDishes.get(i)).getPrice() + "\t\t\t" + ((Meal)foundDishes.get(i)).getWeight() + "\t");
            }
        } else {
            System.out.println("Matches are not found :(");
        }

    }

    public static class WeightComparator implements Comparator<Meal> {
        public WeightComparator() {
        }

        public int compare(Meal meal1, Meal meal2) {
            return meal1.getWeight() - meal2.getWeight();
        }
    }

    public static class PriceComparator implements Comparator<Meal> {
        public PriceComparator() {
        }

        public int compare(Meal meal1, Meal meal2) {
            return meal1.getPrice() - meal2.getPrice();
        }
    }
}
