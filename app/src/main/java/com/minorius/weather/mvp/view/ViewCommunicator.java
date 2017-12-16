package com.minorius.weather.mvp.view;

import com.minorius.weather.mvp.model.weather_items.WeatherItem;
import com.minorius.weather.mvp.model.weather_items.WeatherMarker;

import java.util.List;

/**
 * Created by Minorius on 15.12.2017.
 */

public interface ViewCommunicator {
    void onDataLoaded(List<WeatherMarker> weatherList);
    void onStartLoading();
    void onFinishLoading();
    void onError();
}
