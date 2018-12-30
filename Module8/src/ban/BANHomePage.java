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

	@FindBy(xpath = "//button[text()=\"I'll Pass\"]")
	WebElement modalCancelButton;

	public BANHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitleText() {
		return driver.getTitle();
	}

	public boolean isModalDisplayed() {
		return modalCancelButton.isDisplayed();
	}

	public void closeModalDisplay() {
		modalCancelButton.click();
	}

	public void hoverOverMenuLink(String menuLinkText) {

		Actions actions = new Actions(driver);
		WebElement menuLink = topNav.findElement(By.linkText(menuLinkText));
		actions.moveToElement(menuLink).perform();

	}

	public void clickSubMenuLink(String submenuLinkText) {
		
		topNav.findElement(By.linkText(submenuLinkText)).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector_For_Element_To_Be_Click_After_Hover)));
//		driver.findElement(By.cssSelector(selector_For_Element_To_Be_Click_After_Hover)).click();
		
	}

	public void hoverAndClickMenuLink(String menuLinkText, String submenuLinkText) {
		topNav.findElement(By.linkText(menuLinkText)).findElement(By.linkText(submenuLinkText)).click();
	}

}
