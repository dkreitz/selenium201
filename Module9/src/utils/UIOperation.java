package utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {

	WebDriver driver;

	public UIOperation(WebDriver driver) {
		this.driver = driver;
	}

	public void perform(Properties p, String keyword, String locatorType, String locatorValue, String value) {

		System.out.println("");

		switch (keyword.toUpperCase()) {
		case "GOTOURL":
			driver.get(p.getProperty(value));
			break;
		case "SETTEXT":
			driver.findElement(this.getObject(p, locatorType, locatorValue)).sendKeys(value);
			break;
		case "CLICK":
			driver.findElement(this.getObject(p, locatorType, locatorValue)).click();
			break;
		}

	}

	public By getObject(Properties p, String locatorType, String locatorValue) {

		switch (locatorType.toUpperCase()) {
		case "NAME":
			return By.name(p.getProperty(locatorValue));
		case "XPATH":
			return By.xpath(p.getProperty(locatorValue));
		case "CLASS":
			return By.className(p.getProperty(locatorValue));
		case "ID":
			return By.id(p.getProperty(locatorValue));
		}
		
		return null;

	}

}
