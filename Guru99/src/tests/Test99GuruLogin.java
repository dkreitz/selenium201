package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Guru99HomePage;
import pages.Guru99Login;

public class Test99GuruLogin {

	WebDriver driver;
	Guru99Login objLoginPage;
	Guru99HomePage objHomePage;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}

	/**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){

        //Create Login Page object
    	objLoginPage = new Guru99Login(driver);

    	//Verify login page title
    	String loginPageTitle = objLoginPage.getLoginTitle();
    	Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    	//Login to application
    	objLoginPage.loginToGuru99("mgr123", "mgr!23");

    	//Go the next page
    	objHomePage = new Guru99HomePage(driver);

    	//Verify home page
    	Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }
    
}