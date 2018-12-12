package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

		// open Facebook home page
		driver.get("http://www.facebook.com");
		
		// login to account (using CSS selectors to find elements)
		driver.findElement(By.cssSelector("#email")).sendKeys("dkreitz@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("password");
		driver.findElement(By.cssSelector("#loginbutton")).click();
		
	}

	public static void main(String[] args) {

		Assignment1 myObj = new Assignment1();
		myObj.invokeBrowser();

	}

}
