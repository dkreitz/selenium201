package presentation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNavigateCommands {

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

		navigateCommands();
		
	}

	public void closeBrowser() {
		
		driver.close();
		
	}
	
	public void navigateCommands() {

		try {
			driver.navigate().to("http://www.mindtree.com");
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.linkText("In-store Analytics")).click();
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().forward();
			Thread.sleep(2000);
			driver.navigate().refresh();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

	public static void main(String[] args) {

		TestNavigateCommands obj = new TestNavigateCommands();
		obj.invokeBrowser();
		obj.closeBrowser();

	}

}
