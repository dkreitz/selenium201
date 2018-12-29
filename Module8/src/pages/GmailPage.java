package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailPage {
	
	WebDriver driver;
	By gmailUser = By.name("uid");
	By gmailPassword = By.name("password");
	By gmailTitle = By.className("barry");
	By gmailLoginBtn = By.name("btnlogin");
	
	public void gmailLogin(WebDriver driver) {
		this.driver = driver;		
	}
	
	public void setUserName(String strUserName) {
		driver.findElement(gmailUser).sendKeys(strUserName);
	}

}
