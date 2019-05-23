package com.demoaut.newtours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	
	WebDriver driver;

	@FindBy(name = "userName")
	private WebElement userNameLoginField;
	
	@FindBy(name = "password")
	private WebElement passwordLoginField;
	
	@FindBy(name = "login")
	private WebElement loginButton;
	
	@FindBy(linkText = "SIGN-ON")
	private WebElement signOnLink;
	
	@FindBy(linkText = "REGISTER")
	private WebElement registerLink;
	
	@FindBy(linkText = "SUPPORT")
	private WebElement supportLink;
	
	@FindBy(linkText = "CONTACT")
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
