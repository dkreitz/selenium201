package classroom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropDowns {
	
	WebDriver driver;
	Select dropDown;
	List<WebElement> categoryList;
	
	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Java\\Tools\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		testDropDown();

	}
	
	public void testDropDown() {
		
		WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));
		dropDown = new Select(dropDownElement);
		System.out.println("Is multiple allowed: " + dropDown.isMultiple());
		categoryList = dropDown.getOptions();
		
		for (WebElement category: categoryList) {
			System.out.println(category);
		}
		
//		dropDown.selectByVisibleText("Books");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Roblox");
//		driver.findElement(By.xpath("//*[@id=\"nav-search\"]//input[@value='Go']")).submit();
		
	}
	

	public static void main(String[] args) {
		
		TestDropDowns obj = new TestDropDowns();
		obj.invokeBrowser();

	}

}
