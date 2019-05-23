package com.demoaut.newtours.TestScripts;

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

import com.demoaut.newtours.Pages.BookAFlight;
import com.demoaut.newtours.Pages.FlightFinder;
import com.demoaut.newtours.Pages.Login;
import com.demoaut.newtours.Pages.RegisterUser;
import com.demoaut.newtours.Pages.SelectFlight;
import com.zScalerWorkAround.zScalerWorkAround;

public class BaseTest {
	
	static WebDriver driver;
	
	Login login;
	FlightFinder flightFinder;
	SelectFlight selectFlight;
	BookAFlight bookAFlight;
	RegisterUser registerUser;
	
	@BeforeMethod
	public void openBrowser() throws Exception{
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		zScalerWorkAround.zScalerWorkAround(driver);
		driver.get("http://newtours.demoaut.com/");
		login = new Login(driver);
		flightFinder = new FlightFinder(driver);
		selectFlight = new SelectFlight(driver);
		bookAFlight = new BookAFlight(driver);	
		registerUser = new RegisterUser(driver);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
	
	public static void takeScreenshot() throws Exception{
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		screenShotName = new File("C:\\dev\\workspace\\SeleniumProject\\test-output\\ScreenShots\\" + timeStamp + ".png");
		FileUtils.copyFile(scrFile, screenShotName);
		
		String filePath = screenShotName.toString(); 
		String path = ("<img src=\"file://" + filePath + "\" alt=\"\"/></img>");
		Reporter.log(path); 			
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
