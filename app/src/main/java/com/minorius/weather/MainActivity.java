package com.minorius.weather;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.minorius.weather.adapter.WeatherAdapter;
import com.minorius.weather.di.module.WeatherModule;
import com.minorius.weather.mvp.model.weather_items.WeatherMarker;
import com.minorius.weather.mvp.presenter.WeatherPresenter;
import com.minorius.weather.mvp.view.ViewCommunicator;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewCommunicator {

    @Inject WeatherPresenter        weatherPresenter;
    @Inject WeatherAdapter          weatherAdapter;
    @Inject LinearLayoutManager     linearLayoutManager;

    @BindView(R.id.id_progress_bar_weather)     ProgressBar     progressBar;
    @BindView(R.id.id_recycler)                 RecyclerView    recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.appComponent.plusWeatherComponent(new WeatherModule(this)).inject(this);

        weatherPresenter.getWeather();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(weatherAdapter);
    }

    @Override
    public void onDataLoaded(List<WeatherMarker> weatherItems) {
        weatherAdapter.addToList(weatherItems);
    }

    @Override
    public void onStartLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError() {
        Snackbar.make(recyclerView, "Помилка завантаження", Snackbar.LENGTH_SHORT).show();
    }
}
