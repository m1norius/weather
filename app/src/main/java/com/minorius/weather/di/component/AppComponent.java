package com.minorius.weather.di.component;

import com.minorius.weather.di.module.AppModule;
import com.minorius.weather.di.module.WeatherModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Minorius on 15.12.2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    WeatherComponent plusWeatherComponent(WeatherModule weatherModule);
}
