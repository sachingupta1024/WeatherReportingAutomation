package com.weatherreporting.utils;

public class Compare {
	public boolean compareTemperature(float apiTemp, float uiTemp, String variance) {
		float diff = (apiTemp-uiTemp);
		return getDiff(diff, variance);
	}
	
	public boolean compareHumidity(float apiHumidity, float uiHumidity, String variance) {
		float diff = (apiHumidity-uiHumidity);
		return getDiff(diff, variance);
	}

	public boolean compareWind(float apiWind, float uiWind, String variance) {
		float diff = (apiWind-uiWind);
		return getDiff(diff, variance);
	}
	
	public boolean getDiff(float diff, String var) {
		
		int variance = Integer.parseInt(var);
		if(Math.abs(diff) <= variance)
			return true;
		else
			return false;
	}
}
