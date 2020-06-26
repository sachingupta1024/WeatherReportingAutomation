package com.testvagrant.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomepageObjects {
	
	WebDriver localdriver;
	
	public HomepageObjects(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='notnow']")
	@CacheLookup
	public WebElement noThanksOption;
	
	@FindBy(how=How.XPATH,using="//a[@class='topnavmore']")
	@CacheLookup
	public WebElement extendSubmenuOption;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'WEATHER')]")
	@CacheLookup
	public WebElement weatherMenuOption;

	public void clickNoThanks() {
		noThanksOption.click();
	}

	public void extendSubmenu() {
		extendSubmenuOption.click();
	}

	public void openWeatherMenu() {
		weatherMenuOption.click();
		
	}
}
