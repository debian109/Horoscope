package com.other.horoscope.network;

import android.support.annotation.StringDef;

import com.other.horoscope.model.Horoscope;

import java.lang.annotation.Retention;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by thinh.vo on 16/11/2016.
 */

public interface HoroscopeApi {
    public  String BASE_URL = "http://horoscope-api.herokuapp.com/";
    @GET("horoscope/{period}/{sunsign}")
    Observable<Horoscope> getHoroscopeBy(@Path("period") String period,@Path("sunsign") String sunsign);


    @Retention(SOURCE)
    @StringDef({
            TODAY,
            WEEK,
            MONTH,
            YEAR
    })
    public @interface Period {}
    public static final String TODAY = "today";
    public static final String WEEK = "week";
    public static final String MONTH = "month";
    public static final String YEAR = "year";

    @Retention(SOURCE)
    @StringDef({
            ARIES,
            TAURUS,
            GEMINI,
            CANCER,
            LEO,
            VIRGO,
            LIBRA,
            SCORPIO,
            SAGITTARIUS,
            CAPRICORN,
            AQUARIUS,
            PISCES
    })
    public @interface Suns8 {}
    public static final String ARIES = "aries";
    public static final String TAURUS = "taurus";
    public static final String GEMINI = "gemini";
    public static final String CANCER = "cancer";
    public static final String LEO = "leo";
    public static final String VIRGO = "virgo";
    public static final String LIBRA = "libra";
    public static final String SCORPIO = "scorpio";
    public static final String SAGITTARIUS = "sagittarius";
    public static final String CAPRICORN = "capricorn";
    public static final String AQUARIUS = "aquarius";
    public static final String PISCES = "pisces";
}
