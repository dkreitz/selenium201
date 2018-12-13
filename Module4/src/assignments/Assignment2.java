package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {

	/*
	 * Write a test case to handle keyboard using Selenium. Perform an action like
	 * down keys to move down in application or press “ctrl+a” to select data or
	 * press “ctrl+home” to move to top of the page.
	 */

	WebDriver driver;
	Actions myActions;
	Action seriesOfAction;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

		driver.get("http://toolsqa.com/automation-practice-form/");

		moveDown();
		selectData();
		moveToTop();

	}

	public void moveDown() {

		// perform an action like Down keys to move down
		myActions = new Actions(driver);
		seriesOfAction = myActions.moveToElement(driver.findElement(By.partialLinkText("Partial Link")))
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ARROW_DOWN)
				.build();
		seriesOfAction.perform();

	}

	public void selectData() {

		// press “ctrl+a” to select data
		myActions = new Actions(driver);
		seriesOfAction = myActions.moveToElement(driver.findElement(By.xpath("//strong[contains(text(),'First name')]")))
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.build();
		seriesOfAction.perform();

	}
	
	public void moveToTop() {

		// move to top of the page
		myActions = new Actions(driver);
		seriesOfAction = myActions.moveToElement(driver.findElement(By.xpath("//strong[contains(text(),'First name')]")))
				.keyDown(Keys.CONTROL)
				.sendKeys(Keys.HOME)
				.keyUp(Keys.CONTROL)
				.build();
		seriesOfAction.perform();

	}
	
	public static void main(String[] args) {

		Assignment2 obj = new Assignment2();
		obj.invokeBrowser();

	}

}
