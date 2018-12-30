package ban;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BANHomePage {

	WebDriver driver;

	@FindBy(id = "nav")
	WebElement topNav;

	public BANHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void closeModalDisplay() {

		try {

			// wait up to 2 seconds to see if the modal window appears, then close it
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//button[text()=\"I'll Pass\"]")))).click();
			System.out.println("Found the modal window and closed it.");
			Thread.sleep(2000);
			
		} catch (Exception e) {
			
			// otherwise, just ignore the error if the modal doesn't appear and move on
			// e.printStackTrace();
			System.out.println("Couldn't find the modal window this time.");
			
		}

	}

	public void hoverAndClick(String textToHover, String textToClick) {

		// wait up to 5 seconds for these elements to appear
		WebDriverWait wait = new WebDriverWait(driver, 5);

		// hover over the textToHover link
		WebElement hoverLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(textToHover)));
		Actions action = new Actions(driver);
		action.moveToElement(hoverLink, 10, 5).build().perform();

		// click the textToClick link
		WebElement clickLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(textToClick)));
		clickLink.click();

	}

}
