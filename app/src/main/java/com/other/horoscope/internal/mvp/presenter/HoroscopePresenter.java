package com.other.horoscope.internal.mvp.presenter;

import com.other.horoscope.internal.mvp.MVP;
import com.other.horoscope.internal.mvp.model.HoroscopeModel;
import com.other.horoscope.internal.mvp.view.HoroScopeView;
import com.other.horoscope.model.Horoscope;


import java.util.List;

import javax.inject.Inject;

import easymvp.AbstractPresenter;

/**
 * Created by thinh.vo on 16/11/2016.
 */

public class HoroscopePresenter extends AbstractPresenter<HoroScopeView> {

    HoroscopeModel horoscopeModel;

    @Inject
    public HoroscopePresenter(HoroscopeModel horoscopeModel) {
        this.horoscopeModel = horoscopeModel;
    }


    @Override
    public void onViewAttached(HoroScopeView view) {
        super.onViewAttached(view);
        getView().showLoading();
        horoscopeModel.RequestDay(new MVP.Model.OnLoad<Horoscope>() {
            @Override
            public void onSuccess(Horoscope data) {
                getView().populateToday(data);
            }

            @Override
            public void onFail(String error) {

            }
        });


        horoscopeModel.RequestWeek(new MVP.Model.OnLoad<Horoscope>() {
            @Override
            public void onSuccess(Horoscope data) {
                getView().populateWeek(data);
            }

            @Override
            public void onFail(String error) {

            }
        });

        horoscopeModel.RequestMonth(new MVP.Model.OnLoad<Horoscope>() {
            @Override
            public void onSuccess(Horoscope data) {
                getView().populateMonth(data);
            }

            @Override
            public void onFail(String error) {

            }
        });

        horoscopeModel.RequestYear(new MVP.Model.OnLoad<Horoscope>() {
            @Override
            public void onSuccess(Horoscope data) {
                getView().populateYear(data);
            }

            @Override
            public void onFail(String error) {

            }
        });

    }
}
