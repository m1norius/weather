package com.minorius.weather.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minorius.weather.R;
import com.minorius.weather.mvp.model.weather_items.WeatherItem;

import butterknife.BindView;

/**
 * Created by Minorius on 15.12.2017.
 */

public class WeatherViewHolder extends BaseViewHolder<WeatherItem> {

    @BindView(R.id.id_txt_weather_temp)         TextView temperature;
    @BindView(R.id.id_txt_weather_description)  TextView description;
    @BindView(R.id.id_txt_weather_wind)         TextView wind;
    @BindView(R.id.id_txt_weather_time)         TextView time;

    @BindView(R.id.id_img_weather)              ImageView imageView;

    public WeatherViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_weather);
    }

    @Override
    protected void bindData(WeatherItem data) {
        temperature.setText(data.getTemperature());
        description.setText(data.getDescription());
        wind.setText(data.getWind());
        time.setText(data.getTime());

        int resId = getContext().getResources().getIdentifier(data.getImg(), "drawable", getContext().getPackageName());
        imageView.setImageResource(resId);
    }
}
