package com.other.horoscope.model;

/**
 * Created by thinh.vo on 21/11/2016.
 */

public class Horoscope {
    private String sunsign;

    private String horoscope;

    private String year;

    public String getSunsign ()
    {
        return sunsign;
    }

    public void setSunsign (String sunsign)
    {
        this.sunsign = sunsign;
    }

    public String getHoroscope ()
    {
        return horoscope;
    }

    public void setHoroscope (String horoscope)
    {
        this.horoscope = horoscope;
    }

    public String getYear ()
    {
        return year;
    }

    public void setYear (String year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
        return "Horoscope [sunsign = "+sunsign+", horoscope = "+horoscope+", year = "+year+"]";
    }
}
