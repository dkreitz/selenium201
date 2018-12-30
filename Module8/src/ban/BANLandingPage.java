package ban;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BANLandingPage {

	WebDriver driver;
	
	public BANLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLandingPageTitle() {
		return driver.getTitle();
	}

}
