package com.testvagrant.api.weatherresponse;

public class Wind
{
    private float speed;

    private int deg;

    public void setSpeed(float speed){
        this.speed = speed;
    }
    public float getSpeed(){
        return this.speed;
    }
    public void setDeg(int deg){
        this.deg = deg;
    }
    public int getDeg(){
        return this.deg;
    }
}