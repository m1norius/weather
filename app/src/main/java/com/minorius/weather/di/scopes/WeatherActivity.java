package com.minorius.weather.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Minorius on 15.12.2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface WeatherActivity {
}
