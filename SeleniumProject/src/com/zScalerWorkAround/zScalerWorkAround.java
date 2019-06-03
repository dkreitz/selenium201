package com.zScalerWorkAround;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class zScalerWorkAround {
	
	
	
	public static void zScalerWorkAround(WebDriver driver) throws Exception {
		String userName = "yourMID@mindtree.com";
		String password = "yourPassword";
		driver.get("https://www.google.com/");
		WebElement outlookLogIn = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("userNameInput")));
		String logInUrl = driver.getCurrentUrl().toString();
		System.out.println("Current url is : " + logInUrl );
		if (logInUrl.contains("mindtree")){
			driver.findElement(By.id("userNameInput")).sendKeys(userName);
			driver.findElement(By.id("passwordInput")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(10000);
		}
		System.out.println("About to click the button . . .");
		try{
		driver.findElement(By.linkText("Click here")).click();
		} catch(Exception ignored){};
		WebElement googleLogo = new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo")));
		System.out.println("Button Text : " + driver.findElement(By.id("gbqfbb")).getAttribute("value").toString());
	}
}
