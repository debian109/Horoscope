package com.other.horoscope.internal.mvp.model;

import android.graphics.Color;

import com.other.horoscope.R;
import com.other.horoscope.internal.mvp.MVP;
import com.other.horoscope.model.Sunsign;

import java.util.ArrayList;
import java.util.List;

import static com.other.horoscope.network.HoroscopeApi.AQUARIUS;
import static com.other.horoscope.network.HoroscopeApi.ARIES;
import static com.other.horoscope.network.HoroscopeApi.CANCER;
import static com.other.horoscope.network.HoroscopeApi.CAPRICORN;
import static com.other.horoscope.network.HoroscopeApi.GEMINI;
import static com.other.horoscope.network.HoroscopeApi.LEO;
import static com.other.horoscope.network.HoroscopeApi.LIBRA;
import static com.other.horoscope.network.HoroscopeApi.PISCES;
import static com.other.horoscope.network.HoroscopeApi.SAGITTARIUS;
import static com.other.horoscope.network.HoroscopeApi.SCORPIO;
import static com.other.horoscope.network.HoroscopeApi.TAURUS;
import static com.other.horoscope.network.HoroscopeApi.VIRGO;

/**
 * Created by thinh.vo on 16/11/2016.
 */


public class SunsignModel {

    List<Sunsign> list = new ArrayList<>();

    public SunsignModel() {
        list.add(new Sunsign(ARIES, Color.parseColor("#E4151B"), R.drawable.ic_ares, "Mar 21 - Apr 19"));
        list.add(new Sunsign(TAURUS, Color.parseColor("#E85813"), R.drawable.ic_taurus, "Apr 20 - May 20"));
        list.add(new Sunsign(GEMINI, Color.parseColor("#EE8B00"), R.drawable.ic_gemini, "May 21 - Jun 20"));
        list.add(new Sunsign(CANCER, Color.parseColor("#F7B700"), R.drawable.ic_cancer, "Jun 21 - Jul 22"));
        list.add(new Sunsign(LEO, Color.parseColor("#B0D122"), R.drawable.ic_leo, "July 23 - Aug 22"));
        list.add(new Sunsign(VIRGO, Color.parseColor("#65BD33"), R.drawable.ic_virgo, "Aug 23 - Sep 22"));
        list.add(new Sunsign(LIBRA, Color.parseColor("#02A290"), R.drawable.ic_libra, "Sep 23 - Oct 22"));
        list.add(new Sunsign(SCORPIO, Color.parseColor("#0098C5"), R.drawable.ic_scorpio, "Oct 23 - Nov 21"));
        list.add(new Sunsign(SAGITTARIUS, Color.parseColor("#4275CE"), R.drawable.ic_sagittarius, "Nov 22 - Dec 21"));
        list.add(new Sunsign(CAPRICORN, Color.parseColor("#8659CE"), R.drawable.ic_capricon, "Dec 22 - Jan 19"));
        list.add(new Sunsign(AQUARIUS, Color.parseColor("#D54DC9"), R.drawable.ic_aquarius, "Jan 20 - Feb 18"));
        list.add(new Sunsign(PISCES, Color.parseColor("#DA427F"), R.drawable.ic_pisces, "Feb 19 - Mar 20"));
    }

    public void Request(final MVP.Model.OnLoad<List<Sunsign>> onLoad) {
        onLoad.onSuccess(list);
    }
}
