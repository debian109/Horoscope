package com.other.horoscope.internal.mvp.view;

import com.other.horoscope.internal.mvp.MVP;
import com.other.horoscope.model.Horoscope;

import java.util.List;

/**
 * Created by thinh.vo on 16/11/2016.
 */

public interface HoroScopeView extends MVP.View {
    void populateToday(Horoscope data);
    void populateWeek(Horoscope data);
    void populateMonth(Horoscope data);
    void populateYear(Horoscope data);
}
