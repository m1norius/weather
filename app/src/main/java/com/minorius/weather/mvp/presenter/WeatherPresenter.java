package com.minorius.weather.mvp.presenter;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.minorius.weather.MainActivity;
import com.minorius.weather.api.WeatherApiService;
import com.minorius.weather.App;
import com.minorius.weather.mvp.model.weather_items.WeatherMapper;
import com.minorius.weather.mvp.model.response.BaseWeather;
import com.minorius.weather.mvp.model.weather_items.WeatherMarker;
import com.minorius.weather.mvp.view.ViewCommunicator;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Minorius on 15.12.2017.
 */

public class WeatherPresenter extends BasePresenter<ViewCommunicator> implements Observer<BaseWeather> {

    @Inject WeatherApiService weatherApiService;
    @Inject WeatherMapper weatherMapper;

    @Inject
    public WeatherPresenter() {

    }

    public void getWeather() {
        Observable<BaseWeather> cakesResponseObservable = weatherApiService.getWeather();
        subscribe(cakesResponseObservable, this);
    }

    @Override
    public void onSubscribe(Disposable d) {
        getView().onStartLoading();
    }

    @Override
    public void onNext(BaseWeather baseWeather) {
        List<WeatherMarker> weatherItems = weatherMapper.mapWeather(baseWeather.getList());
        getView().onDataLoaded(weatherItems);
    }

    @Override
    public void onError(Throwable e) {
        getView().onError();
        getView().onFinishLoading();
    }

    @Override
    public void onComplete() {
        getView().onFinishLoading();
    }
}