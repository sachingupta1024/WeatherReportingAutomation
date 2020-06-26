package com.testvagrant.api.weatherresponse;

public class Sys
{
    private String country;

    private int sunrise;

    private int sunset;

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setSunrise(int sunrise){
        this.sunrise = sunrise;
    }
    public int getSunrise(){
        return this.sunrise;
    }
    public void setSunset(int sunset){
        this.sunset = sunset;
    }
    public int getSunset(){
        return this.sunset;
    }
}
