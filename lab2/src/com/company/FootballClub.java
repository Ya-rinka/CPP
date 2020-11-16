package com.company;

import java.util.Objects;

public class FootballClub {
    private String name;
    private int year;
    private String city;

    FootballClub(String s_name, int i_year, String s_city) {
        name = s_name;
        year = i_year;
        city = s_city;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Club - " + name + " " + year + " " + city;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FootballClub fclub = (FootballClub) obj;
        return Objects.equals(name, fclub.name);
    }
}