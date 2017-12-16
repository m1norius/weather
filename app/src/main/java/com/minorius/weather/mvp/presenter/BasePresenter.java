package com.minorius.weather.mvp.presenter;

import com.minorius.weather.mvp.view.ViewCommunicator;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Minorius on 15.12.2017.
 */

public class BasePresenter<V extends ViewCommunicator> {

    @Inject protected V view;

    protected V getView() {
        return view;
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}

