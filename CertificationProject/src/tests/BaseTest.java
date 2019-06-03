package tests;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.BookFlight;
import pages.FlightFinder;
import pages.Login;
import pages.RegisterUser;
import pages.SelectFlight;

public class BaseTest {
	
	static WebDriver driver;
	
	Login login;
	FlightFinder flightFinder;
	SelectFlight selectFlight;
	BookFlight bookFlight;
	RegisterUser registerUser;
	
	@BeforeMethod
	public void openBrowser() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/");

		login = new Login(driver);
		flightFinder = new FlightFinder(driver);
		selectFlight = new SelectFlight(driver);
		bookFlight = new BookFlight(driver);	
		registerUser = new RegisterUser(driver);
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	public static void takeScreenshot() throws Exception {
		
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		screenShotName = new File("C:\\Code\\Java\\Repos\\CertificationProject\\test-output\\ScreenShots\\" + timeStamp + ".png");
		FileUtils.copyFile(scrFile, screenShotName);
		
		String filePath = screenShotName.toString(); 
		String path = ("<img src=\"file://" + filePath + "\" alt=\"\"/></img>");
		Reporter.log(path);
		
	}
	
}
