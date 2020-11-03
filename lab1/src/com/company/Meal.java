package com.company;

public class Meal {
    private String name;
    private String description;
    private int price;
    private int weight;

    Meal(String c_name, String c_description, int c_price, int c_weight) {
        this.name = c_name;
        this.description = c_description;
        this.price = c_price;
        this.weight = c_weight;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }

    public int getWeight() {
        return this.weight;
    }
}