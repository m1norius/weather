package com.minorius.weather.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.weather.R;
import com.minorius.weather.mvp.model.weather_items.DayItem;

import butterknife.BindView;

/**
 * Created by Minorius on 16.12.2017.
 */

public class DayViewHolder extends BaseViewHolder<DayItem> {

    @BindView(R.id.id_txt_weather_week_day)     TextView weekDay;
    @BindView(R.id.id_txt_weather_day)          TextView day;

    public DayViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_day);
    }

    @Override
    protected void bindData(DayItem data) {
        weekDay.setText(data.getDayOfWeek());
        day.setText(data.getDay());
    }
}
