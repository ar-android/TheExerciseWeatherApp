package com.ocit.theexercise.services;

import com.ocit.theexercise.models.CityWeather;
import com.ocit.theexercise.models.ModelWeather;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by ar-android on 28/11/2015.
 */
public interface APIServices {

    @GET("/data/2.5/forecast/daily?q=Yogyakarta&mode=json&units=metric&cnt=7&appid=77ee56802bfebdefc551c4376012585a")
    Observable<ModelWeather> getData();

    @GET("/data/2.5/weather?q=yogyakarta,id&mode=json&units=metric&appid=2de143494c0b295cca9337e1e96b00e0")
    Observable<CityWeather> getCityWeatherObservable();
}