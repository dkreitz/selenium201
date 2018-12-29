package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage {

	WebDriver driver;

	@FindBy(name = "uid")
	WebElement usergmail;

	@FindBy(name = "password")
	WebElement passwordGmail;

	@FindBy(className = "barry")
	WebElement titleText;

	@FindBy(name = "btnLogin")
	WebElement login;

	public GmailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {
		usergmail.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		passwordGmail.sendKeys(strPassword);
	}

	public void clickLogin() {
		login.click();
	}

	public String getLoginTitle() {
		return titleText.getText();

	}

	public void loginGmail(String strUserName, String strPassword) {
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}

}
