package com.other.horoscope.internal.di.component;


import com.other.horoscope.internal.di.module.HoroscopeModelModule;
import com.other.horoscope.internal.di.module.SunsignModelModule;
import com.other.horoscope.internal.di.scope.PerHoroscopeModel;
import com.other.horoscope.internal.di.scope.PerSunsignModel;
import com.other.horoscope.internal.mvp.model.HoroscopeModel;
import com.other.horoscope.internal.mvp.presenter.HoroscopePresenter;
import com.other.horoscope.internal.mvp.presenter.SunsignPresenter;
import com.other.horoscope.ui.fragment.ContentFragment;
import com.other.horoscope.ui.fragment.DetailFragment;

import dagger.Component;

/**
 * Created by thinh.vo on 16/11/2016.
 */

@PerHoroscopeModel
@Component(dependencies = AppComponent.class,modules={HoroscopeModelModule.class})
public interface HoroscopeModelComponent {
    void inject(DetailFragment detailFragment);
    HoroscopePresenter horoscopePresenter();
}
