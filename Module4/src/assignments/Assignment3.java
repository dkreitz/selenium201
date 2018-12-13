package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	/*
	 * Write a test case to fetch page content of any application. 
	 * Page Content means the text of full page and print in console. 
	 * From page content text validate verbose of application.
	 */

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

		driver.get("http://demoqa.com/");
		
		// fetch page content and print in console
		String bodyText = driver.findElement(By.tagName("body")).getText();
		System.out.println(bodyText);
		
		// validate verbose text
		String myText = "Welcome to WordPress. This is your first post. Edit or delete it, then start writing!";
		if (bodyText.contains(myText)) {
			System.out.println("PASS!");
		}

	}

	public static void main(String[] args) {

		Assignment3 obj = new Assignment3();
		obj.invokeBrowser();

	}

}
