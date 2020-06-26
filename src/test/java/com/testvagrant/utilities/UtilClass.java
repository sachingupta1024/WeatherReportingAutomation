package com.testvagrant.utilities;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.api.weatherresponse.Main;
import com.testvagrant.api.weatherresponse.Wind;
import com.testvagrant.baseclass.BaseClass;
import com.testvagrant.dao.builder.GetWeatherInfo;
import com.testvagrant.ui.pageobjects.HomepageObjects;
import com.testvagrant.ui.pageobjects.WeatherInfoPageObjects;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class UtilClass extends BaseClass {
	
	public static GetWeatherInfo getResponseFromAPI() {
		
		RequestSpecification request = setRequestData();

		GetWeatherInfo getWeatherInfo = RestAssured.given().spec(request)
				.when().get(ReadConfig.getResource())
				.then().log().all().extract().response().as(GetWeatherInfo.class);

		return getWeatherInfo;
	}
	
	public static GetWeatherInfo getUIInfo() {
		
		driver.get(ReadConfig.getBaseURL());
		WebDriverWait exwait = new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HomepageObjects homePageObjects = new HomepageObjects(driver);
		exwait.until(ExpectedConditions.visibilityOf(homePageObjects.noThanksOption));
		homePageObjects.clickNoThanks();
		exwait.until(ExpectedConditions.visibilityOf(homePageObjects.extendSubmenuOption));
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
		float temperatureInFahrenheit = UtilClass.getFloatValueFromString(weatherInfoPageObjects.temperatureField.getText());
		
		GetWeatherInfo getWeatherInfo = new GetWeatherInfo();
		
		Main getMain = new Main();
		getMain.setHumidity(humidity);
		getMain.setTemp(convertFahrenheitToKelvin(temperatureInFahrenheit));
		
		Wind getWind = new Wind();
		getWind.setSpeed(wind);
		
		getWeatherInfo.setMain(getMain);
		getWeatherInfo.setWind(getWind);
		
		return getWeatherInfo;
	}
	
	public static RequestSpecification setRequestData() {
		RequestSpecification request = new RequestSpecBuilder()
				.setBaseUri(ReadConfig.getBaseURIAPI())
				.addQueryParam("q", ReadConfig.getCityName())
				.addQueryParam("appid", ReadConfig.getAPIKey())
				.addHeader("content-type","application/json").build();
		
		return request;
	}
	
	/*
	 * Util method to generate values from string based on a Patter given
	 * */
	public static float getFloatValueFromString(String text) {
	    Pattern p = Pattern.compile("[0-9]*\\.?[0-9]+");
	    Matcher m = p.matcher(text);
	    if(m.find())
	    	return Float.parseFloat(m.group());
	    else
	    	return 0;
	}

	public static float convertFahrenheitToKelvin(float tempInFahrenheit) {
		float temp = (float) (((tempInFahrenheit -32)*(0.56)) + 273.15) ;
		return temp;
	}
}
