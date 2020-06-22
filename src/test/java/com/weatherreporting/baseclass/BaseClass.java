package com.weatherreporting.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.weatherreporting.utils.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeTest
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		new ReadConfig();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
