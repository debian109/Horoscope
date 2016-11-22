package com.other.horoscope.internal.di.component;



import com.other.horoscope.internal.di.module.AppModule;
import com.other.horoscope.internal.di.module.AppSharePreferenceModule;
import com.other.horoscope.internal.di.module.NetworkModule;
import com.other.horoscope.network.HoroscopeApi;
import com.other.horoscope.preference.AppSharePreference;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by thinh.vo on 16/11/2016.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, AppSharePreferenceModule.class})
public interface AppComponent {
    HoroscopeApi horoscopeApi();

    AppSharePreference appSharePreference();
}
