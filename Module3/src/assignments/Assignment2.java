package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

		// open Mindtree home page
		driver.get("http://www.mindtree.com");
		
		// go to Banking page
		driver.findElement(By.linkText("Industries")).click();
		driver.findElement(By.linkText("Banking")).click();

		// go to Cloud page
		driver.findElement(By.linkText("Services")).click();
		driver.findElement(By.linkText("Cloud")).click();
		
		// refresh the current page
		driver.navigate().refresh();
		
		// navigate to previous page (Banking)
		driver.navigate().back();
		
		// navigate to next page (Cloud)
		driver.navigate().forward();
	
		
	}

	public static void main(String[] args) {

		Assignment2 myObj = new Assignment2();
		myObj.invokeBrowser();

	}

}
