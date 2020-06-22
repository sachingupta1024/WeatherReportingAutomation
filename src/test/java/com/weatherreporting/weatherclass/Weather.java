package com.weatherreporting.weatherclass;

public class Weather {
	
	float wind;
	float humidity;
	float temperature;
	
	public Weather(Float wind, Float humidity,Float temperature) { 
	        this.wind = wind; 
	        this.humidity = humidity; 
	        this.temperature = temperature;
	} 
	
	public float getWind() {
		return wind;
	}
	public void setWind(float wind) {
		this.wind = wind;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}
