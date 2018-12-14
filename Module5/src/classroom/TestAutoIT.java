package classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAutoIT {
	
	WebDriver driver;

	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\java\\tools\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/imghp?hl=en&tab=wi");

	}
	
	public void useAutoITForUpload() {
		driver.findElement(By.className("S3Wjs")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Upload an image')]")).click();
		driver.findElement(By.id("qbfile")).click();
	}
	
	public static void main(String[] args) {

	}

}
