package presentation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

	WebDriver driver;
	String imagePath = "C:\\Code\\facebookHome.png";
	File tempFile, permanentFile;
	TakesScreenshot screenShot;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

		driver.get("http://www.facebook.com");

	}

	public void takeScreenshot() {

		try {

			permanentFile = new File(imagePath);
			if (permanentFile.exists()) {
				throw new Exception("Image already exists");
			}
			screenShot = (TakesScreenshot) driver;
			tempFile = screenShot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(tempFile, permanentFile);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {

		TakeScreenShot obj = new TakeScreenShot();
		obj.invokeBrowser();
		obj.takeScreenshot();

	}

}
