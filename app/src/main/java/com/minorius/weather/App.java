package com.minorius.weather;

import android.app.Application;
import android.util.Log;

import com.minorius.weather.di.component.AppComponent;

import com.minorius.weather.di.component.DaggerAppComponent;
import com.minorius.weather.di.module.AppModule;

/**
 * Created by Minorius on 15.12.2017.
 */

public class App extends Application {

    public static AppComponent appComponent;
    private String baseUrl = "http://api.openweathermap.org";

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this, baseUrl))
                .build();

    }

    public static void myLog(Object o){
        Log.d("Log", "log ... "+o);
    }
}
