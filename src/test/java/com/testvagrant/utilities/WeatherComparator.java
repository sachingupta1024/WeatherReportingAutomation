package com.testvagrant.utilities;

import com.testvagrant.dao.builder.Weather;

public class WeatherComparator {

	public boolean Compare(Weather apiValues, Weather uiValues) {

		if (( Math.abs(apiValues.getHumidity()-uiValues.getHumidity()) < Integer.parseInt(ReadConfig.getHumidityVariance()) )
				&& ( Math.abs(apiValues.getWind()-uiValues.getWind())< Integer.parseInt(ReadConfig.getWindVariance() ) 
						&& (Math.abs(apiValues.getTemperature()-uiValues.getTemperature())<Integer.parseInt(ReadConfig.getHumidityVariance()) )))
			return true;
		else 
			return false;
	}
}






