package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFacebookWithDependency {

	WebDriver driver;

	@Test
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
	}

	@Test(dependsOnMethods = { "openBrowser" })
	public void loginToFacebook() {

		driver.get("http://www.facebook.com");
		driver.findElement(By.cssSelector("#email")).sendKeys("dkreitz@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("password");
		driver.findElement(By.cssSelector("#loginbutton")).click();

	}

}
