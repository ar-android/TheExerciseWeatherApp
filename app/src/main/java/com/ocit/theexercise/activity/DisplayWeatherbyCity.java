package com.ocit.theexercise.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ocit.theexercise.R;
import com.ocit.theexercise.models.CityWeather;
import com.ocit.theexercise.services.APIServices;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by ar-android on 28/11/2015.
 */
public class DisplayWeatherbyCity extends AppCompatActivity {

    Context context = this;
    private TextView tvCity;
    private ImageView imgIcon;
    private TextView tvTemp, tvClouds, tvWind, tvCloudiness, tvPressure, tvHumidity, tvSunrise, tvSunset, tvCoords, tvGetat;
    private String timeGet;
    private static final String TAG = "DisplayWeatherbyCity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);

        tvCity = (TextView) findViewById(R.id.tvCity);
        tvTemp = (TextView) findViewById(R.id.tvTemp);
        tvClouds = (TextView) findViewById(R.id.tvClouds);
        tvGetat = (TextView) findViewById(R.id.tvGetat);
        tvWind = (TextView) findViewById(R.id.tvWind);
        tvCloudiness = (TextView) findViewById(R.id.tvCloudiness);
        tvPressure = (TextView) findViewById(R.id.tvPressure);
        tvHumidity = (TextView) findViewById(R.id.tvHumidity);
        tvSunrise = (TextView) findViewById(R.id.tvSunrise);
        tvSunset = (TextView) findViewById(R.id.tvSunset);
        tvCoords = (TextView) findViewById(R.id.tvCoords);

        imgIcon = (ImageView) findViewById(R.id.imgIcon);

        startRxApi();

    }

    private void startRxApi() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String BASE_URL = "http://api.openweathermap.org/";
        final String MAIN_ICON_URL = "http://openweathermap.org/img/w/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APIServices services = retrofit.create(APIServices.class);

        Observable<CityWeather> cityWeatherObservable = services.getCityWeatherObservable();
        cityWeatherObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CityWeather>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(DisplayWeatherbyCity.this, "Finish", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Error", e.toString());
                    }

                    @Override
                    public void onNext(CityWeather city) {

                        tvCity.setText(city.getName() + ", " + city.getSys().getCountry());
                        tvTemp.setText(city.getMain().getTemp() + "°C");
                        tvClouds.setText(city.getWeather().get(0).getMain());
                        tvWind.setText(city.getWind().getSpeed() + "m/s");
                        tvCloudiness.setText(city.getWeather().get(0).getDescription());
                        tvPressure.setText(city.getMain().getPressure() + " hpa");
                        tvHumidity.setText(city.getMain().getHumidity() + " %");
                        tvSunrise.setText(convertTimesmapHour(city.getSys().getSunrise()));
                        tvSunset.setText(convertTimesmapHour(city.getSys().getSunset()));
                        tvCoords.setText("[" + city.getCoord().getLon() + "," + city.getCoord().getLat() + "]");
                        tvGetat.setText("Get At " + convertTimesmapYear(city.getDt()));

                        Glide.with(context)
                                .load(MAIN_ICON_URL + city.getWeather().get(0).getIcon() + ".png")
                                .into(imgIcon);
                    }
                });
    }

    String convertTimesmapYear(String times){
        long settime = Long.decode(times);
        SimpleDateFormat yyyyf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        String timeY = yyyyf.format(new Date(settime * 1000));
        return timeY;
    }

    String convertTimesmapHour(String times){
        long settime = Long.decode(times);
        SimpleDateFormat hhf = new SimpleDateFormat("HH:mm");
        String timeH = hhf.format(new Date(settime*1000));
        return timeH;
    }
}