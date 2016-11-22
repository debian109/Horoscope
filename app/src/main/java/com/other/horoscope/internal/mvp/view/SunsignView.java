package com.other.horoscope.internal.mvp.view;

import com.other.horoscope.model.Horoscope;
import com.other.horoscope.model.Sunsign;

import java.util.List;

/**
 * Created by thinh.vo on 16/11/2016.
 */

public interface SunsignView {
    void populate(List<Sunsign> data);
}
