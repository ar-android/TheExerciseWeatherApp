package com.ocit.theexercise.models;

import java.util.ArrayList;

/**
 * Created by ar-android on 28/11/2015.
 */
public class WeatherList {

    public String dt;
    public Temp temp;
    public String pressure;
    public String humidity;
    public ArrayList<Weather> weather;
    public String speed;
    public String deg;
    public String clouds;
    public String rain;

    public String getDt() {
        return dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDeg() {
        return deg;
    }

    public String getClouds() {
        return clouds;
    }

    public String getRain() {
        return rain;
    }
}