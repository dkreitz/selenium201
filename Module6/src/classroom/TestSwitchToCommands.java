package classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSwitchToCommands {

	WebDriver driver;
	WebDriverWait myWait;
	String parentWindow, childWindow1;
	int numOfWindows;

	public void invokeBrowser(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.get(url);

	}

	public void switchToAlert() {

		invokeBrowser("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.alertIsPresent());
		Alert myAlert = driver.switchTo().alert();
		String alertText = myAlert.getText();
		System.out.println(alertText);
		myAlert.accept();

	}
	
	public void switchToWindows() {
		
		invokeBrowser("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		parentWindow = driver.getWindowHandle().toString();
		childWindow1 = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(childWindow1);
		driver.findElement(By.linkText("Try it Yourself »")).click();
		
	}

}
