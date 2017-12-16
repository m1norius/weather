package com.minorius.weather.di.component;

import com.minorius.weather.MainActivity;
import com.minorius.weather.di.module.WeatherModule;
import com.minorius.weather.di.scopes.WeatherActivity;

import dagger.Subcomponent;

/**
 * Created by Minorius on 15.12.2017.
 */

@Subcomponent(modules = WeatherModule.class)
@WeatherActivity
public interface WeatherComponent {
    void inject(MainActivity mainActivity);
}
