package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	
	/* Create an automation script in Selenium to test whether all the links 
	 * (located at the bottom of the page) in the following section 
	 * (not complete page) of https://facebook.com are working or not ? */

	WebDriver driver;
	ArrayList<String> tabs;
	String openNewTabKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		testFacebookLinks();
		
	}
	
	public void testFacebookLinks() {

		driver.get("https://facebook.com");
		
		// Get the list of links at the bottom of the page
		WebElement footerElement = driver.findElement(By.xpath("//ul[contains(@class,'pageFooterLinkList')]"));
		List<WebElement> footerLinks = footerElement.findElements(By.tagName("a"));
	
		for (WebElement link: footerLinks) {
			
			System.out.print("Testing [" + link.getText() + "] = ");

			// open link in a new tab
			link.sendKeys(openNewTabKeys);

			// focus on new tab and print the title
			tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			System.out.println(driver.getTitle());
			
			// close the current tab and go back to the first one
			driver.close();
			driver.switchTo().window(tabs.get(0));
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Assignment6 obj = new Assignment6();
		obj.invokeBrowser();

	}

}
