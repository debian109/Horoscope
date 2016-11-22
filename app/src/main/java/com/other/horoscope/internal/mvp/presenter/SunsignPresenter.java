package com.other.horoscope.internal.mvp.presenter;

import com.other.horoscope.internal.mvp.MVP;
import com.other.horoscope.internal.mvp.model.HoroscopeModel;
import com.other.horoscope.internal.mvp.model.SunsignModel;
import com.other.horoscope.internal.mvp.view.HoroScopeView;
import com.other.horoscope.internal.mvp.view.SunsignView;
import com.other.horoscope.model.Horoscope;
import com.other.horoscope.model.Sunsign;

import java.util.List;

import javax.inject.Inject;

import easymvp.AbstractPresenter;

/**
 * Created by thinh.vo on 16/11/2016.
 */

public class SunsignPresenter extends AbstractPresenter<SunsignView> implements MVP.Model.OnLoad<List<Sunsign>> {

    SunsignModel sunsignModel;

    @Inject
    public SunsignPresenter(SunsignModel sunsignModel) {
        this.sunsignModel = sunsignModel;
    }


    @Override
    public void onViewAttached(SunsignView view)
    {
        super.onViewAttached(view);
        sunsignModel.Request(this);
    }


    @Override
    public void onSuccess(List<Sunsign> data) {
        getView().populate(data);
    }

    @Override
    public void onFail(String error) {

    }
}
