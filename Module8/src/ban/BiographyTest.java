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
		String actualTitle = myHomePage.getPageTitleText();
		String expectedTitle = "Online Bookstore: Books, NOOK ebooks, Music, Movies & Toys | Barnes & Noble®";

		assertEquals(actualTitle, expectedTitle);

	}

	@Test(dependsOnMethods = { "test_GoToHomePage" })
	public void test_GoToBiographyPage() {

		BANHomePage myHomePage = new BANHomePage(driver);
		
		// close the modal window if it's displayed
		if (myHomePage.isModalDisplayed()) {
			myHomePage.closeModalDisplay();
		}

		// hover over "Books" to open the sub-menu
		// and click the "Biography" sub-menu link
		myHomePage.hoverOverMenuLink("Books");
		myHomePage.clickSubMenuLink("Biography");
//		myHomePage.hoverAndClickMenuLink("Books", "Biography");

		// verify text "Bestsellers" and "Biography"

	}

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}

	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}
