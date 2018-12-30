package guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99LoginPage {

	WebDriver driver;

	@FindBy(name = "uid")
	WebElement guruUsername;

	@FindBy(name = "password")
	WebElement guruPassword;

	@FindBy(className = "barone")
	WebElement guruTitle;

	@FindBy(name = "btnLogin")
	WebElement guruLoginButton;

	public Guru99LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {
		guruUsername.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		guruPassword.sendKeys(strPassword);
	}

	public void clickLogin() {
		guruLoginButton.click();
	}

	public String getLoginTitle() {
		return guruTitle.getText();
	}

	public void loginToGuru99(String strUserName, String strPasword) {

		this.setUserName(strUserName);
		this.setPassword(strPasword);
		this.clickLogin();

	}

}
