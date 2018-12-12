package presentation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGetCommands {

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

		getCommands();
		
	}
	
	public void getCommands() {

		driver.get("http://www.facebook.com");

		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);
		
		driver.findElement(By.linkText("About")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current page URL address is: " + currentUrl);
		
		String subHeader = driver.findElement(By.xpath("//span[starts-with(text(), 'Community')]")).getText();
		System.out.println("The text of the header is: " + subHeader);

	}

	public static void main(String[] args) {

		TestGetCommands myObj = new TestGetCommands();
		myObj.invokeBrowser();

	}

}
