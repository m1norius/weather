package com.minorius.weather.mvp.model.weather_items;

import android.annotation.SuppressLint;

import com.minorius.weather.App;
import com.minorius.weather.mvp.model.response.WeatherList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Minorius on 16.12.2017.
 */

public class WeatherMapper {

    private String lastDate = "";
    private List<WeatherMarker> list = new ArrayList<>();

    @Inject
    public WeatherMapper() {

    }

    public List<WeatherMarker> mapWeather(List<WeatherList> baseWeathers) {

        for (WeatherList weatherList : baseWeathers) {
            WeatherItem item = new WeatherItem();
            item.setDate(weatherList.getDtTxt());
            item.setTemperature(String.valueOf((int) weatherList.getMain().getTemp()) + "°");
            item.setImg("icon" + weatherList.getWeather().get(0).getIcon());
            item.setDescription(firstUpperCase(weatherList.getWeather().get(0).getDescription()));
            item.setWind("Вітер " + String.valueOf(weatherList.getWind().getSpeed())+" м/с");
            item.setTime(weatherList.getDtTxt().substring(11, 16));

            getWeekDay(weatherList.getDt(), weatherList.getDtTxt());

            App.myLog("****************************");

            list.add(item);
        }
        return list;
    }

    private void getWeekDay(long dt, String dtTxt) {

        String newDate = dtTxt.substring(0, 11); //16.12.2017

        if (!lastDate.equals(newDate)) {
            lastDate = newDate;
            String dayOfWeek = firstUpperCase(convertUNIXTimeToRealDate(dt * 1000));

            list.add(new DayItem(lastDate.replaceAll("-", "."), dayOfWeek));
        }
    }

    private String convertUNIXTimeToRealDate(long UNIXTime) {

        Date date = new Date(UNIXTime);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");

        return simpleDateformat.format(date);
    }

    private String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
