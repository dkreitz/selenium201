package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {

	/*
	 * Create a program to go to https://www.dropbox.com/. Print the title of the
	 * page 5 times. Each time a title is printed, browser should get closed. To get
	 * the title again, the browser should open again.
	 */
	
	WebDriver driver;

	@Test(invocationCount = 5)
	public void openDropbox() {
		
		driver.get("https://www.dropbox.com");
		String myTitle = driver.getTitle();
		System.out.println("My title is: " + myTitle);
		
	}

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	
}
