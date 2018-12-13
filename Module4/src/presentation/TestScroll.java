package presentation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestScroll {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		testScroll();
		
	}
	
	public void testScroll() {
		
		jse = (JavascriptExecutor)driver;
		
		// Way 1
//		jse.executeScript("scroll(0,800)");
		
		// Way 2
//		WebElement myElement = driver.findElement(By.xpath("//span[contains(text(), 'Home Gift Guide Live')]"));
//		int x = myElement.getLocation().x;
//		int y = myElement.getLocation().y;
//		String command = String.format("window.scrollTo(%d, %d)", x, y);
//		jse.executeScript(command);

		// Way 3
		WebElement myElement = driver.findElement(By.xpath("//span[contains(text(), 'Home Gift Guide Live')]"));
		jse.executeScript("arguments[0].scrollIntoView()", myElement);
		
	}
	
	public static void main(String[] args) {
		
		TestScroll obj = new TestScroll();
		obj.invokeBrowser();

	}

}
