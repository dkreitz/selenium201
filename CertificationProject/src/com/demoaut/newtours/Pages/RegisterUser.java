package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterUser {
	
	WebDriver driver;
	
	@FindBy(name = "firstName")
	private WebElement firstNameInputField;
	
	@FindBy(name = "lastName")
	private WebElement lastNameInputField;
	
	@FindBy(name = "phone")
	private WebElement phoneInputField;
	
	@FindBy(name = "userName")
	private WebElement emailInputField;	
	
	@FindBy(name = "address1")
	private WebElement address1InputField;	
	
	@FindBy(name = "city")
	private WebElement cityInputField;	
	
	@FindBy(name = "state")
	private WebElement stateInputField;	
	
	@FindBy(name = "postalCode")
	private WebElement postalCodeInputField;	
	
	@FindBy(name = "email")
	private WebElement userNameInputField;	
	
	@FindBy(name = "password")
	private WebElement passwordInputField;	
	
	@FindBy(name = "confirmPassword")
	private WebElement confirmPasswordInputField;	
	
	@FindBy(name = "register")
	private WebElement submit;	
	
	@FindBy(xpath = "//tbody/tr[3]/td/p[2]")
	private WebElement successMessage;	
	
	public RegisterUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	
	public String registerNewUser() {
		firstNameInputField.sendKeys("userFirstName");
		lastNameInputField.sendKeys("UserLastName");
		phoneInputField.sendKeys("8675309");	
		emailInputField.sendKeys("lastname@test.com");
		address1InputField.sendKeys("8008135 North Street");
		cityInputField.sendKeys("Anytown");
		stateInputField.sendKeys("Washington");
		postalCodeInputField.sendKeys("654781");
		userNameInputField.sendKeys("newuser");
		passwordInputField.sendKeys("password");
		confirmPasswordInputField.sendKeys("password");
		submit.click();
		return successMessage.getText();
	}

}
