package com.testvagrant.ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WeatherInfoPageObjects {
	
WebDriver localdriver;
	
	public WeatherInfoPageObjects(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='searchBox']")
	@CacheLookup
	public WebElement searchCityOption;
	
	@FindBy(how=How.XPATH,using="//label[@for='Pune']")
	@CacheLookup
	public WebElement selectCityOption;
	
	@FindBy(how=How.XPATH,using="(//div[@class='leaflet-popup-content']//span[@class='heading'])[2]")
	@CacheLookup
	public WebElement windField;
	
	@FindBy(how=How.XPATH,using="(//div[@class='leaflet-popup-content']//span[@class='heading'])[3]")
	@CacheLookup
	public WebElement humidityField;
	
	@FindBy(how=How.XPATH,using="(//div[@class='leaflet-popup-content']//span[@class='heading'])[5]")
	@CacheLookup
	public WebElement temperatureField;
	
	public void searchCity(String city) {
		searchCityOption.sendKeys(city);
	}

	public void selectEnteredCity() {
		selectCityOption.click();
	}

	public void getVisibleCitiesOnMapAndCLickOnSelectedCity() {
		List<WebElement> listOfCities =localdriver.findElements(By.xpath("//div[@class='cityText']"));
		for(int i=0; i<listOfCities.size(); i++) {
			WebElement city = listOfCities.get(i);
			if(city.getText().equalsIgnoreCase("Pune")) {
				city.click();
				break;
			}
		}
	}

}
