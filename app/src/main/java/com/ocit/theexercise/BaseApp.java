package com.ocit.theexercise;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by ar-android on 30/11/2015.
 */
public class BaseApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
