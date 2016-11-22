package com.other.horoscope.internal.di.module;


import com.other.horoscope.internal.di.scope.PerHoroscopeModel;
import com.other.horoscope.internal.di.scope.PerSunsignModel;
import com.other.horoscope.internal.mvp.model.HoroscopeModel;
import com.other.horoscope.internal.mvp.model.SunsignModel;
import com.other.horoscope.network.HoroscopeApi;
import com.other.horoscope.preference.AppSharePreference;

import dagger.Module;
import dagger.Provides;

/**
 * Created by thinh.vo on 16/11/2016.
 */

@Module
public class SunsignModelModule {

    @PerSunsignModel
    @Provides
    SunsignModel provideSunsignModel() {
        return new SunsignModel();
    }
}
