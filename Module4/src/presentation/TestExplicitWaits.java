package presentation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExplicitWaits {

	WebDriver driver;
	WebDriverWait myWait;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);


	}

	public void closeBrowser() {
		
		driver.close();
		
	}
	
	public void testExplicitWaits() {
		
		myWait = new WebDriverWait(driver, 10);
		myWait.until(ExpectedConditions.alertIsPresent());
		// switch to alert and accept it

	}

	public static void main(String[] args) {

		TestExplicitWaits obj = new TestExplicitWaits();
		obj.invokeBrowser();
		obj.closeBrowser();

	}

}
