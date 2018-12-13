package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	/*
	 * Go to https://facebook.com. 
	 * Verify following 3 things in all the browsers (Firefox, Chrome, Internet Explorer/Safari, Opera) 
	 * 1. Title is Facebook Log In or Sign Up 
	 * 2. Facebook helps you connect and share with the people in your life. 
	 * 3. It's free and always will
	 */

	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		checkFacebook(driver);
		
		driver.quit();

	}
	
	public void checkFacebook(WebDriver driver) {
		
		// go to Facebook.com
		driver.get("https://facebook.com");
		
		// verify title
		String myTitle = driver.getTitle();
		if (myTitle.equals("Facebook - Log In or Sign Up")) {
			System.out.println("Verify Title: PASS");
		}
		
		// verify "connect with friends"
		String myBodyText = driver.findElement(By.tagName("body")).getText();
		String myConnectText = "Connect with friends";
		if (myBodyText.contains(myConnectText)) {
			System.out.println("Verify Connect Text: PASS");
		}
		
		// verify "it's free..."
		String myFreeText = "It’s free and always will be";
		if (myBodyText.contains(myFreeText)) {
			System.out.println("Verify Free Text: PASS");
		}
		
	}

	public static void main(String[] args) {

		Assignment4 obj = new Assignment4();
		obj.invokeBrowser();

	}

}
