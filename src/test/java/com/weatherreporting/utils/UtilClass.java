package com.weatherreporting.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class UtilClass {
	
	public static JsonPath getResponseFromAPI() {
		
		RequestSpecification request = new RequestSpecBuilder()
				.setBaseUri(ReadConfig.getBaseURIAPI())
				.addQueryParam("q", ReadConfig.getCityName())
				.addQueryParam("appid", ReadConfig.getAPIKey())
				.addHeader("content-type","application/json").build();

		String response = RestAssured.given().spec(request)
					.when().get(ReadConfig.getResource())
					.then().log().all().extract().response().asString();

		JsonPath jp = new JsonPath(response);
		return jp;
	}
	
	/*
	 * Util method to geenrate values from string based on a Patter given*/
	public static float getFloatValueFromString(String text) {
	    Pattern p = Pattern.compile("[0-9]*\\.?[0-9]+");
	    Matcher m = p.matcher(text);
	    if(m.find())
	    	return Float.parseFloat(m.group());
	    else
	    	return 0;
	}

	public static float convertKelvinToFahrenheit(float tempInKelvin) {
		float temp = (float) (((tempInKelvin - 273.15) * (1.8)) + 32);
		return temp;
	}

}
