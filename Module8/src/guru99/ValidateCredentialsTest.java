package guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateCredentialsTest {

	/*
	 * Enter username and password on the Login Page and validate if a user is able
	 * to login into the application or not.
	 */

	WebDriver driver;
	Guru99LoginPage objLogin;
	Guru99HomePage objHomePage;

	@Test(priority = 0)
	public void test_Home_Page_Appear_Correct() {

		// Go to login page
		objLogin = new Guru99LoginPage(driver);
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

		// Login to application
		objLogin.loginToGuru99("mgr123", "mgr!23");

		// Go the next page
		objHomePage = new Guru99HomePage(driver);
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

	}

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

	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}
