package presentation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestActions {

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

		driver.get("http://www.facebook.com");

		testKeyboardMouseActions();

	}

	public void testKeyboardMouseActions() {

		myActions = new Actions(driver);
		seriesOfAction = myActions.moveToElement(driver.findElement(By.id("email"))).click().keyDown(Keys.SHIFT)
				.sendKeys("dankreitz").keyUp(Keys.SHIFT).doubleClick().contextClick().build();
		seriesOfAction.perform();

	}

	public static void main(String[] args) {

		TestActions obj = new TestActions();
		obj.invokeBrowser();

	}

}
