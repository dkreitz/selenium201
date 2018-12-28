package assignments;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

	/*
	 * Write a code to book a ticket at http://newtours.demoaut.com. A screenshot
	 * should be taken on every page as the control progresses from one page to next
	 * page irrespective of the fact that the test case is passing or failing (use
	 * TestNG assertion to verify this). As the work on one page gets completed take
	 * a screenshot.
	 * 
	 * Search on Google how to include a timestamp along with the name of
	 * screenshot. If you don’t include a timestamp, all the screenshots will be
	 * overwritten. Figure out how to overcome this.
	 */

	WebDriver driver;
	String imageFolder = "screenshots\\";
	File tempFile, permanentFile;
	TakesScreenshot screenShot;

	@Test
	public void openMercuryTours() {

		driver.get("http://newtours.demoaut.com");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Welcome: Mercury Tours";

		assertEquals(actualTitle, expectedTitle);

	}

	@Test(dependsOnMethods = { "openMercuryTours" })
	public void loginToMercuryTours() {

		driver.findElement(By.name("userName")).sendKeys("dkreitz");
		driver.findElement(By.name("password")).sendKeys("dkreitz");
		driver.findElement(By.name("login")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Find a Flight: Mercury Tours:";

		assertEquals(actualTitle, expectedTitle);

	}

	@Test(dependsOnMethods = { "loginToMercuryTours" })
	public void findFlights() {

		// use the default values and continue
		driver.findElement(By.name("findFlights")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Select a Flight: Mercury Tours";

		assertEquals(actualTitle, expectedTitle);

	}

	@Test(dependsOnMethods = { "findFlights" })
	public void selectFlights() {

		// use the default values and continue
		driver.findElement(By.name("reserveFlights")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Book a Flight: Mercury Tours";

		assertEquals(actualTitle, expectedTitle);

	}

	@Test(dependsOnMethods = { "selectFlights" })
	public void bookFlights() {

		// use the default values and continue
		driver.findElement(By.name("buyFlights")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Flight Confirmation: Mercury Tours";

		assertEquals(actualTitle, expectedTitle);

	}

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void takeScreenshot() {
		System.out.print("Say cheese... ");

		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss_SSS").format(new Date());
		String imageFilename = imageFolder + "newtours_" + timestamp + ".png";

		try {

			permanentFile = new File(imageFilename);
			if (permanentFile.exists()) {
				throw new Exception("Image already exists:" + imageFilename);
			}
			screenShot = (TakesScreenshot) driver;
			tempFile = screenShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(tempFile, permanentFile);

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		System.out.println("Screenshot taken: " + imageFilename);
	}

	@AfterTest
	public void afterAllTests() {
		driver.quit();
	}

}
