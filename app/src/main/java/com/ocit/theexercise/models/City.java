package com.ocit.theexercise.models;

/**
 * Created by ar-android on 28/11/2015.
 */
public class City {
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public String population;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }
}
