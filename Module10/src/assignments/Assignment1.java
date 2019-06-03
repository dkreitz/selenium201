package assignments;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {
	
	WebDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.get("https://www.last.fm/music/+free-music-downloads");

		useAutoITForDownload();

	}

	public void useAutoITForDownload() {
		
		try {
			
			WebElement element = driver.findElement((By.xpath("//*[@id=\"freedownloads-section\"]/table/tbody/tr[1]/td[3]/a")));
			
			Actions myactions = new Actions(driver);
			myactions.contextClick(element).perform();
			
			Runtime.getRuntime().exec("autoit-script.exe");
			/* Executes the following AutoIt source:
			 * 
			 * 		WinWait("Save As", "", 5)
			 * 		ControlFocus("Save As", "", "Edit1")
			 * 		Sleep(2000)
			 * 		ControlSetText("Save As", "", "Edit1", "C:\MusicAssignment\mysong.mp3")
			 * 		Sleep(2000)
			 * 		ControlClick("Save As", "", "Button2")
			 * 
			 */
			
			System.out.println("The file has been saved successfully");

		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}

	public static void main(String[] args) {

		Assignment1 obj = new Assignment1();
		obj.invokeBrowser();

	}

	
}
