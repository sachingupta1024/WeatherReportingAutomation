package com.weatherreporting.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.weatherreporting.baseclass.BaseClass;
import com.weatherreporting.pageobjectclasses.HomepageObjects;
import com.weatherreporting.pageobjectclasses.WeatherInfoPageObjects;
import com.weatherreporting.utils.Compare;
import com.weatherreporting.utils.ReadConfig;
import com.weatherreporting.utils.UtilClass;
import com.weatherreporting.weatherclass.Weather;

import io.restassured.path.json.JsonPath;

public class VerifyWeatherInformation extends BaseClass{

	@Test(description = "Verify the Difference between various weather info")
	public static void verifyTemperatureDifference() {
		
		List<Weather> weatherObject = new ArrayList<Weather>();
		
		List<Float> apiData = getDataFromAPI();
		
		List<Float> uiData = getDataFromUI();
		
		Weather apiValues = new Weather(apiData.get(0),apiData.get(1),apiData.get(2));
		
		Weather uiValues = new Weather(uiData.get(0),uiData.get(1),uiData.get(2));
		
		weatherObject.add(apiValues);
		weatherObject.add(uiValues);
		
		for(int i=0; i< apiData.size(); i++) {
			System.out.println("====="+apiData.get(i));
		}
		
		for(int i=0; i< uiData.size(); i++) {
			System.out.println("====="+uiData.get(i));
		}
		
		Compare compare = new Compare();
		
		Boolean tempCompareFlag = compare.compareTemperature(apiValues.getTemperature(), uiValues.getTemperature(), ReadConfig.getTempVariance());
		
		Boolean humidityCompareFlag = compare.compareHumidity(apiValues.getHumidity(), uiValues.getHumidity(), ReadConfig.getHumidityVariance());
		
		Boolean windCompareFlag = compare.compareWind(apiValues.getWind(), uiValues.getWind(), ReadConfig.getWindVariance());
		
		Assert.assertTrue(windCompareFlag && humidityCompareFlag && tempCompareFlag);
		
	}
	
	public static ArrayList<Float> getDataFromAPI() {

		// Getting response JsonPath from Weather API
		JsonPath jsonpath = UtilClass.getResponseFromAPI();
		float wind = jsonpath.getFloat(ReadConfig.getWindJsonPath());
		float humidity = jsonpath.getFloat(ReadConfig.getHumidityJsonPath());
		float tempInKelvin = (float) (jsonpath.getFloat(ReadConfig.getTemperatureJsonPath()));
		
		float temp = UtilClass.convertKelvinToFahrenheit(tempInKelvin);
		
		//Creating List object to store data from response
		ArrayList<Float> apiData = new ArrayList<Float>();
		apiData.add(wind);
		apiData.add(humidity);
		apiData.add(temp);
		
		return  apiData;
	}
	
	public static ArrayList<Float> getDataFromUI(){
		
		driver.get(ReadConfig.getBaseURL());
		WebDriverWait exwait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HomepageObjects homePageObjects = new HomepageObjects(driver);
		homePageObjects.clickNoThanks();
		homePageObjects.extendSubmenu();
		homePageObjects.openWeatherMenu();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WeatherInfoPageObjects weatherInfoPageObjects = new WeatherInfoPageObjects(driver);
		weatherInfoPageObjects.searchCity(ReadConfig.getCityName());
		weatherInfoPageObjects.selectEnteredCity();
	
		weatherInfoPageObjects.getVisibleCitiesOnMapAndCLickOnSelectedCity();

		// Getting Data from the City Pop-up available on Map	
		exwait.until(ExpectedConditions.visibilityOf(weatherInfoPageObjects.windField));
		float wind = UtilClass.getFloatValueFromString(weatherInfoPageObjects.windField.getText());
		float humidity = UtilClass.getFloatValueFromString(weatherInfoPageObjects.humidityField.getText());
		float temperature = UtilClass.getFloatValueFromString(weatherInfoPageObjects.temperatureField.getText());
		
		//Creating List object to store data from UI(web)
		ArrayList<Float> uiData = new ArrayList<Float>();
		uiData.add(wind);
		uiData.add(humidity);
		uiData.add(temperature);
		return  uiData;
	}
}
