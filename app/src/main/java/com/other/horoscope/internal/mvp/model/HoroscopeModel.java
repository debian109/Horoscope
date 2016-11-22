package com.other.horoscope.internal.mvp.model;

import com.other.horoscope.internal.mvp.MVP;
import com.other.horoscope.model.Horoscope;
import com.other.horoscope.network.HoroscopeApi;
import com.other.horoscope.preference.AppSharePreference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func4;
import rx.schedulers.Schedulers;

import static com.other.horoscope.network.HoroscopeApi.ARIES;
import static com.other.horoscope.network.HoroscopeApi.MONTH;
import static com.other.horoscope.network.HoroscopeApi.TODAY;
import static com.other.horoscope.network.HoroscopeApi.WEEK;
import static com.other.horoscope.network.HoroscopeApi.YEAR;

/**
 * Created by thinh.vo on 16/11/2016.
 */


public class HoroscopeModel {

    HoroscopeApi horoscopeApi;
    AppSharePreference appSharePreference;

    public HoroscopeModel(HoroscopeApi horoscopeApi, AppSharePreference appSharePreference) {
        this.horoscopeApi = horoscopeApi;
        this.appSharePreference = appSharePreference;
    }

    public void RequestDay(final MVP.Model.OnLoad<Horoscope> onLoad) {
        String sun8=appSharePreference.getString("sun8");
        if(sun8.equals(""))
            sun8=ARIES;
        Observable<Horoscope> day=horoscopeApi.getHoroscopeBy(TODAY,sun8);
        day.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Horoscope>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoad.onFail(e.toString());
            }

            @Override
            public void onNext(Horoscope horoscope) {
                onLoad.onSuccess(horoscope);
                onCompleted();
            }
        });
    }

    public void RequestWeek(final MVP.Model.OnLoad<Horoscope> onLoad) {
        String sun8=appSharePreference.getString("sun8");
        if(sun8.equals(""))
            sun8=ARIES;
        Observable<Horoscope> week=horoscopeApi.getHoroscopeBy(WEEK,sun8);
        week.debounce(500, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Horoscope>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoad.onFail(e.toString());
            }

            @Override
            public void onNext(Horoscope horoscope) {
                onLoad.onSuccess(horoscope);
                onCompleted();
            }
        });
    }

    public void RequestMonth(final MVP.Model.OnLoad<Horoscope> onLoad) {
        String sun8=appSharePreference.getString("sun8");
        if(sun8.equals(""))
            sun8=ARIES;
        Observable<Horoscope> month=horoscopeApi.getHoroscopeBy(MONTH,sun8);
        month.debounce(1000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Horoscope>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoad.onFail(e.toString());
            }

            @Override
            public void onNext(Horoscope horoscope) {
                onLoad.onSuccess(horoscope);
                onCompleted();
            }
        });
    }

    public void RequestYear(final MVP.Model.OnLoad<Horoscope> onLoad) {
        String sun8=appSharePreference.getString("sun8");
        if(sun8.equals(""))
            sun8=ARIES;
        Observable<Horoscope> year=horoscopeApi.getHoroscopeBy(YEAR,sun8);
        year.debounce(1500, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Horoscope>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onLoad.onFail(e.toString());
            }

            @Override
            public void onNext(Horoscope horoscope) {
                onLoad.onSuccess(horoscope);
                onCompleted();
            }
        });
    }



    public void Request(final MVP.Model.OnLoad<List<Horoscope>> onLoad) {
        String sun8=appSharePreference.getString("sun8");
        if(sun8.equals(""))
            sun8=ARIES;
        Observable<Horoscope> day=horoscopeApi.getHoroscopeBy(TODAY,sun8);
        Observable<Horoscope> week=horoscopeApi.getHoroscopeBy(WEEK,sun8);
        Observable<Horoscope> month=horoscopeApi.getHoroscopeBy(MONTH,sun8);
        Observable<Horoscope> year=horoscopeApi.getHoroscopeBy(YEAR,sun8);
        Observable.zip(day, week, month, year, new Func4<Horoscope, Horoscope, Horoscope, Horoscope, List<Horoscope>>() {
            @Override
            public List<Horoscope> call(Horoscope horoscope, Horoscope horoscope2, Horoscope horoscope3, Horoscope horoscope4) {
                List<Horoscope> list=new ArrayList<Horoscope>();
                list.add(horoscope);
                list.add(horoscope2);
                list.add(horoscope3);
                list.add(horoscope4);
                return list;
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Horoscope>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onLoad.onFail(e.toString());
                    }

                    @Override
                    public void onNext(List<Horoscope> horoscopes) {
                        onLoad.onSuccess(horoscopes);
                        onCompleted();
                    }
                });
    }
}
