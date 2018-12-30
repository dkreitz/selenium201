package guru99;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePage {

	WebDriver driver;

	@FindBy(xpath = "//table//tr[@class='heading3']")
	WebElement guruHomePageUserName;

	public Guru99HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHomePageDashboardUserName() {
		return guruHomePageUserName.getText();
	}

}