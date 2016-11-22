package com.other.horoscope.model;

import android.os.Parcelable;

/**
 * Created by thinh.vo on 21/11/2016.
 */

public class Sunsign {

    private String suns8;

    private int color;

    private int res;

    private String date;

    public String getSunsign ()
    {
        return suns8;
    }

    public void setSunsign (String suns8)
    {
        this.suns8 = suns8;
    }

    public String getSuns8() {
        return suns8;
    }

    public void setSuns8(String suns8) {
        this.suns8 = suns8;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Sunsign(String suns8, int color, int res, String date) {
        this.suns8 = suns8;
        this.color = color;
        this.res = res;
        this.date = date;
    }
}
