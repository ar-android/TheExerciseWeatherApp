package com.ocit.theexercise.models;

import java.util.ArrayList;

/**
 * Created by ar-android on 28/11/2015.
 */
public class CityWeather {

    public Coord coord;
    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public Wind wind;
    public Clouds clouds;
    public String dt;
    public Sys sys;
    public int id;
    public String name;
    public String cod;

    public Coord getCoord() {
        return coord;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public String getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCod() {
        return cod;
    }
}
