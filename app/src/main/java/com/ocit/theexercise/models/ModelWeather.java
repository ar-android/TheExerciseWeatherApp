package com.ocit.theexercise.models;

import java.util.ArrayList;

/**
 * Created by ar-android on 28/11/2015.
 */
public class ModelWeather {

    public City city;
    public String cod;
    public String message;
    public String cnt;
    public ArrayList<WeatherList> list;

    public City getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public String getCnt() {
        return cnt;
    }

    public ArrayList<WeatherList> getList() {
        return list;
    }
}
