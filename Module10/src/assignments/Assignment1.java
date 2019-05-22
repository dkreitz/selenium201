package assignments;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.get("https://www.google.com/search?q=selenium&tbm=isch");

		useAutoITForDownload();

	}

	public void useAutoITForDownload() {
		
		try {
			
			WebElement element = driver.findElement((By.xpath("//*[@id=\"freedownloads-section\"]/table/tbody/tr[1]/td[3]/a")));
			
			
			driver.findElement(By.className("S3Wjs")).click();
			driver.findElement(By.linkText("Upload an image")).click();
			driver.findElement(By.id("qbfile")).click();
			Runtime.getRuntime().exec("autoit-script.exe");

		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}

	public static void main(String[] args) {

		Assignment1 obj = new Assignment1();
		obj.invokeBrowser();

	}

	
}
