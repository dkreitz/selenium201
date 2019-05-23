package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	
	WebDriver driver;

	@FindBy(name = "userName")
	@CacheLookup
	private WebElement userNameLoginField;
	
	@FindBy(name = "password")
	@CacheLookup
	private WebElement passwordLoginField;
	
	@FindBy(name = "login")
	@CacheLookup
	private WebElement loginButton;
	
	@FindBy(linkText = "SIGN-ON")
	@CacheLookup
	private WebElement signOnLink;
	
	@FindBy(linkText = "REGISTER")
	@CacheLookup
	private WebElement registerLink;
	
	@FindBy(linkText = "SUPPORT")
	@CacheLookup
	private WebElement supportLink;
	
	@FindBy(linkText = "CONTACT")
	@CacheLookup
	private WebElement contactLink;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegisterBtn() {
		registerLink.click();
	}
	
	public void applicationLogin(String userName, String password) {
		userNameLoginField.sendKeys(userName);
		passwordLoginField.sendKeys(password);
		loginButton.click();
	}
	
	public void menuHeaderClickThrough() {
		String signOnText = signOnLink.getText();
		System.out.println("Link Text = " + signOnText);
		signOnLink.click();
	}
	
}
