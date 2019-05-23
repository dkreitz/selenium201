package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FlightFinder {

	WebDriver driver;
	
	@FindBy(css = "input[value='Business']")
	@CacheLookup
	private WebElement businessClassRadioButton;
	
	@FindBy(name = "airline")
	@CacheLookup
	private WebElement airlinePreferenceDropDown;
	
	@FindBy(name = "findFlights")
	@CacheLookup
	private WebElement findFlightsContinueButton;
	
	public FlightFinder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void findFlights() {
		businessClassRadioButton.click();
		Select drpDown = new Select(airlinePreferenceDropDown);
		drpDown.selectByIndex(1);
		findFlightsContinueButton.click();
	}
	
}
