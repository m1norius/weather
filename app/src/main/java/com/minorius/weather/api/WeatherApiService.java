package com.minorius.weather.api;

import com.minorius.weather.mvp.model.response.BaseWeather;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Minorius on 15.12.2017.
 */

public interface WeatherApiService {

    @POST("/data/2.5/forecast?id=693457&lang=ua&units=metric&APPID=fc99e17a4e2e60ff654905c284a63414")
    Observable<BaseWeather> getWeather();
}
