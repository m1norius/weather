package com.minorius.weather.mvp.model.weather_items;

/**
 * Created by Minorius on 16.12.2017.
 */

public class DayItem implements WeatherMarker{
    private String day;
    private String dayOfWeek;

    public DayItem(String day, String dayOfWeek) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
