package com.weatherreporting.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	static Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception :"+e.getMessage());
		}
	}
	
	public static String getBaseURL() {
		return pro.getProperty("baseURL");
	}
	
	public static String getCityName() {
		return pro.getProperty("city");
	}
	
	public static String getWindJsonPath() {
		return pro.getProperty("windJsonPath");
	}
	
	public static String getHumidityJsonPath() {
		return pro.getProperty("humidityJsonPath");
	}
	
	public static String getTemperatureJsonPath() {
		return pro.getProperty("temperatureJsonPath");
	}

	public static String getAPIKey() {
		return pro.getProperty("key");
	}
	
	public static String getBaseURIAPI() {
		return pro.getProperty("baseURIAPI");
	}

	public static String getResource() {
		return pro.getProperty("resource");
	}
	
	public static String getTempVariance() {
		return pro.getProperty("tempVariance");
	}
	
	public static String getWindVariance() {
		return pro.getProperty("windVariance");
	}
	
	public static String getHumidityVariance() {
		return pro.getProperty("humidityVariance");
	}
}
