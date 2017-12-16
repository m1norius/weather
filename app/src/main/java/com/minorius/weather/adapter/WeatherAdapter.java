package com.minorius.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.minorius.weather.App;
import com.minorius.weather.adapter.viewholder.BaseViewHolder;
import com.minorius.weather.adapter.viewholder.DayViewHolder;
import com.minorius.weather.adapter.viewholder.WeatherViewHolder;
import com.minorius.weather.mvp.model.weather_items.DayItem;
import com.minorius.weather.mvp.model.weather_items.WeatherItem;
import com.minorius.weather.mvp.model.weather_items.WeatherMarker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minorius on 15.12.2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<WeatherMarker> list = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        WeatherMarker marker = list.get(position);

        if (marker instanceof WeatherItem){
            return 1;
        }else if (marker instanceof DayItem){
            return 2;
        }

        App.myLog("getItemViewType");
        return super.getItemViewType(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1){
            return new WeatherViewHolder(parent);
        }
        return new DayViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addToList(List<WeatherMarker> weatherItems){
        this.list.addAll(weatherItems);
        notifyDataSetChanged();
    }

    public void clearList(){
        list.clear();
    }
}
