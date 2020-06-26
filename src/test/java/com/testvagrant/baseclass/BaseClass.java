package com.testvagrant.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.testvagrant.utilities.ReadConfig;
import com.testvagrant.utilities.UtilClass;

public class BaseClass {
	
	public static WebDriver driver;
	UtilClass utilClass;
	
	@BeforeSuite
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		new ReadConfig();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
