package com.minorius.weather.di.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.minorius.weather.adapter.WeatherAdapter;
import com.minorius.weather.api.WeatherApiService;
import com.minorius.weather.di.scopes.WeatherActivity;
import com.minorius.weather.mvp.view.ViewCommunicator;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Minorius on 15.12.2017.
 */
@Module
public class WeatherModule {

    private ViewCommunicator viewCommunicator;

    public WeatherModule(ViewCommunicator viewCommunicator) {
        this.viewCommunicator = viewCommunicator;
    }

    @WeatherActivity
    @Provides
    WeatherApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(WeatherApiService.class);
    }

    @WeatherActivity
    @Provides
    ViewCommunicator provideView() {
        return viewCommunicator;
    }




    @WeatherActivity
    @Provides
    LinearLayoutManager provideLayoutManager(Context context){
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false);
    }

    @WeatherActivity
    @Provides
    WeatherAdapter provideWeatherAdapter(){
        return new WeatherAdapter();
    }
}
