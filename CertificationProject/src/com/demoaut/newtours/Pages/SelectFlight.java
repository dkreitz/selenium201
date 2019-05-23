package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectFlight {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[contains(@value,'361')]")
	@CacheLookup
	private WebElement departFlight;
	
	@FindBy(xpath = "//input[contains(@value,'632')]")
	@CacheLookup
	private WebElement returnFlight;
	
	@FindBy(name = "reserveFlights")
	@CacheLookup
	private WebElement submit;
	
	public SelectFlight(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void flightSelection() {
		departFlight.click();
		returnFlight.click();
		submit.click();
	}
	
}
