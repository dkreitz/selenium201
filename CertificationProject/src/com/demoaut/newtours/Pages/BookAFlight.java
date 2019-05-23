package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BookAFlight {
	
	WebDriver driver;
	
	@FindBy(name = "passFirst0")
	@CacheLookup
	private WebElement firstName;
	
	@FindBy(name = "passLast0")
	@CacheLookup
	private WebElement lastName;
	
	@FindBy(name = "creditnumber")
	@CacheLookup
	private WebElement creditNumber;
	
	@FindBy(name = "buyFlights")
	@CacheLookup
	private WebElement submit;
	
	public BookAFlight(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	
	public void bookFlight(String fName, String lName, String number) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		creditNumber.sendKeys(number);
		submit.click();
	}

}
