package com.other.horoscope.internal.di.component;


import com.other.horoscope.internal.di.module.HoroscopeModelModule;
import com.other.horoscope.internal.di.module.SunsignModelModule;
import com.other.horoscope.internal.di.scope.PerHoroscopeModel;
import com.other.horoscope.internal.di.scope.PerSunsignModel;
import com.other.horoscope.internal.mvp.presenter.HoroscopePresenter;
import com.other.horoscope.internal.mvp.presenter.SunsignPresenter;
import com.other.horoscope.ui.fragment.ContentFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by thinh.vo on 16/11/2016.
 */

@PerSunsignModel
@Component(dependencies = AppComponent.class,modules={SunsignModelModule.class})
public interface SunsignModelComponent {
    void inject(ContentFragment contentFragment);
    SunsignPresenter sunsignPresenter();
}
