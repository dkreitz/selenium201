package ban;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BiographyTest {

	/*
	 * Go to http://barnesandnoble.com and keep the pointer over "Books", in the
	 * sub-menu click "Biography". When the page corresponding to Biography opens,
	 * verify whether the text "Bestsellers" and "Biography" are there or not.
	 */

	WebDriver driver;

	@Test(priority = 0)
	public void test_GoToHomePage() {

		driver.get("https://www.barnesandnoble.com/");

		BANHomePage myHomePage = new BANHomePage(driver);

		// close the modal window if it's displayed
		myHomePage.closeModalDisplay();
		
		String actualTitle = myHomePage.getHomePageTitle();
		String expectedTitle = "Online Bookstore: Books, NOOK ebooks, Music, Movies & Toys | Barnes & Noble®";

		assertEquals(actualTitle, expectedTitle);

	}

	@Test(dependsOnMethods = { "test_GoToHomePage" })
	public void test_GoToBiographyPage() {

		BANHomePage myHomePage = new BANHomePage(driver);

		// hover over "Books" and click the "Biography" link
		myHomePage.hoverAndClick("Books", "Biography");

		// verify text "Bestsellers" and "Biography"
		BANLandingPage myLandingPage = new BANLandingPage(driver);
		String landingPageTitle = myLandingPage.getLandingPageTitle();
		String actualTitle = landingPageTitle.split("\\|")[0].trim();
		String expectedTitle = "Biography, Books";

		assertEquals(actualTitle, expectedTitle);

	}

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}
