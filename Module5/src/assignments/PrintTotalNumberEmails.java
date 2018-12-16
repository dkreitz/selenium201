package assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintTotalNumberEmails {
	
	/* Create an automation script in Selenium to print total number of e-mails in Gmail */
	
	WebDriver driver;
	WebDriverWait myWait;
	String username, password;
	
	public void getCredentials() {
		
		System.out.print("Enter your Gmail username: ");
		BufferedReader readerUser = new BufferedReader(new InputStreamReader(System.in));
		try {
			username = readerUser.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print("Enter your Gmail password: ");
		BufferedReader readerPass = new BufferedReader(new InputStreamReader(System.in));
		try {
			password = readerPass.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		loginToGmail();

	}
	
	public void loginToGmail() {
		
		myWait = new WebDriverWait(driver, 60);

		driver.get("https://mail.google.com/");
		driver.findElement(By.id("identifierId")).sendKeys(username); 
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]//input")).sendKeys(password); 

		// wait for Next button to be clickable
		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]//span"))).click();
		
		// wait for 2-step verification if configured
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Mail"))).click();;
		
		// wait for All Mail view
		myWait.until(ExpectedConditions.urlContains("#all"));

		checkTotalNumberEmails();
		
	}
	
	public void checkTotalNumberEmails() {
		
		driver.navigate().refresh(); // refresh the page to clear injected HTML
		
		WebElement totalNumberElement = driver.findElement(By.xpath("//span[contains(text(),' of ')]/span[2]"));
		System.out.println("Total Number of Emails: " + totalNumberElement.getText());

	}

	public static void main(String[] args) {
		
		PrintTotalNumberEmails obj = new PrintTotalNumberEmails();
		obj.getCredentials();
		obj.invokeBrowser();

	}

}
