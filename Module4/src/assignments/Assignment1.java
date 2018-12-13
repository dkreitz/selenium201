package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	/* Write a test case to validate checkbox is checked or unchecked, 
	 * check element exists or not 
	 * and read text box read only and disabled attribute. */

	WebDriver driver;
	
	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		doAssignment();
		
	}
	
	public void doAssignment() {
		
		// validate that a check box is checked or unchecked
		WebElement myCheckBox = driver.findElement(By.id("profession-1"));
		if (myCheckBox.isSelected()) {
			System.out.println("The check box is checked.");
		} else {
			System.out.println("The check box is not checked.");
		}
		
		// check if element exists or not
		if (myCheckBox.isDisplayed()) {
			System.out.println("The check box exists on the page.");
		} else {
			System.out.println("The check box does not exist on the page.");
		}
		
		// read the "read-only" and "disabled" attributes of a text box
		WebElement myTextBox = driver.findElement(By.xpath("//input[@name='firstname']"));
		System.out.println("The readonly attribute is: " + myTextBox.getAttribute("readonly"));
		System.out.println("The disabled attribute is: " + myTextBox.getAttribute("disabled"));		
				
	}

	public static void main(String[] args) {
		
		Assignment1 obj = new Assignment1();
		obj.invokeBrowser();

	}

}
