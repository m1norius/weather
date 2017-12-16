
package com.minorius.weather.mvp.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snow {

    @SerializedName("3h")
    @Expose
    private double _3h;

    public double get3h() {
        return _3h;
    }

    public void set3h(double _3h) {
        this._3h = _3h;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "_3h=" + _3h +
                '}';
    }
}
