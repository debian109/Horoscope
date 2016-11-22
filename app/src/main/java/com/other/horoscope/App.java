package com.other.horoscope;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.other.horoscope.internal.di.component.AppComponent;
import com.other.horoscope.internal.di.component.DaggerAppComponent;
import com.other.horoscope.internal.di.module.AppSharePreferenceModule;
import com.other.horoscope.internal.di.module.NetworkModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Aksiom on 6/29/2016.
 */
public class App extends MultiDexApplication {

    private static AppComponent appComponent;

    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        appComponent = DaggerAppComponent.builder()
                .networkModule(new NetworkModule())
                .appSharePreferenceModule(new AppSharePreferenceModule(this))
                .build();
    }
    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
