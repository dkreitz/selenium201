package presentation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestValidationCommands {

	WebDriver driver;
	WebDriverWait myWait;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		driver.get("http://www.paytm.com");
		validate();

	}

	public void validate() {
		
		WebElement postPaidCheckbox = driver.findElement(By.xpath("//label[contains(text(), 'Postpaid')]"));
		myWait = new WebDriverWait(driver, 10);
		myWait.until(ExpectedConditions.elementToBeClickable(postPaidCheckbox));
		postPaidCheckbox.click();
		
		WebElement ffCheckBox = driver.findElement(By.xpath("//i[@class='shPe']"));
		System.out.println("Is 'Fast Forward' checkbox checked? " + ffCheckBox.isSelected());
		if (ffCheckBox.isSelected() == false) {
			ffCheckBox.click();
		}
		
		WebElement proceedButton = driver.findElement(By.xpath("//button[contains(text(),'Bill')]"));
		if (proceedButton.isEnabled() == true) {
			proceedButton.click();			
		}
		
	}

	public static void main(String[] args) {
		
		TestValidationCommands obj = new TestValidationCommands();
		obj.invokeBrowser();

	}

}
