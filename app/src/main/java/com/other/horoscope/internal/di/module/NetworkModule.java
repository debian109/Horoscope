package com.other.horoscope.internal.di.module;

import com.other.horoscope.network.HoroscopeApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by thinh.vo on 16/11/2016.
 */

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public HoroscopeApi providePlaceAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HoroscopeApi.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(HoroscopeApi.class);
    }
}
