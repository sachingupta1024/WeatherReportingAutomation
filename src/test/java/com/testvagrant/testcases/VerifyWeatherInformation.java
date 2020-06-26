package com.testvagrant.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testvagrant.baseclass.BaseClass;
import com.testvagrant.dao.builder.GetWeatherData;
import com.testvagrant.dao.builder.GetWeatherInfo;
import com.testvagrant.dao.builder.Weather;
import com.testvagrant.utilities.WeatherComparator;

public class VerifyWeatherInformation extends BaseClass{

	@Test(description = "Verify the Difference between various weather info")
	public static void verifyWeatherInfoDifference() {
		
		GetWeatherData getWeatherData = new GetWeatherData();

		//Getting data from both the sources
		GetWeatherInfo getWeatherInfoFromAPI = getWeatherData.getDataFromAPI();
		GetWeatherInfo getWeatherInfoFromUI = getWeatherData.getDataFromUI();
		
		//Setting data in the Weather Class for both the Objects
		Weather apiValues = new Weather(getWeatherInfoFromAPI.getWind().getSpeed(), getWeatherInfoFromAPI.getMain().getHumidity(), getWeatherInfoFromAPI.getMain().getTemp());
		Weather uiValues = new Weather(getWeatherInfoFromUI.getWind().getSpeed(), getWeatherInfoFromUI.getMain().getHumidity(), getWeatherInfoFromUI.getMain().getTemp());
	
		WeatherComparator weatherComparator = new WeatherComparator();
		
		// Asserting on the basis of both Object's comparison
		Assert.assertTrue(weatherComparator.Compare(apiValues, uiValues));
	}
}
