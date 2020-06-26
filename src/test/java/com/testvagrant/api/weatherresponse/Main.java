package com.testvagrant.api.weatherresponse;

public class Main
{
    private float temp;

    private double feels_like;

    private double temp_min;

    private double temp_max;

    private int pressure;

    private float humidity;

    private int sea_level;

    private int grnd_level;

    public void setTemp(float temp){
        this.temp = temp;
    }
    public float getTemp(){
        return this.temp;
    }
    public void setFeels_like(double feels_like){
        this.feels_like = feels_like;
    }
    public double getFeels_like(){
        return this.feels_like;
    }
    public void setTemp_min(double temp_min){
        this.temp_min = temp_min;
    }
    public double getTemp_min(){
        return this.temp_min;
    }
    public void setTemp_max(double temp_max){
        this.temp_max = temp_max;
    }
    public double getTemp_max(){
        return this.temp_max;
    }
    public void setPressure(int pressure){
        this.pressure = pressure;
    }
    public int getPressure(){
        return this.pressure;
    }
    public void setHumidity(float humidity){
        this.humidity = humidity;
    }
    public float getHumidity(){
        return this.humidity;
    }
    public void setSea_level(int sea_level){
        this.sea_level = sea_level;
    }
    public int getSea_level(){
        return this.sea_level;
    }
    public void setGrnd_level(int grnd_level){
        this.grnd_level = grnd_level;
    }
    public int getGrnd_level(){
        return this.grnd_level;
    }
}
