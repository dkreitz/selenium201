package commonLibs;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDriver {

	private WebDriver oDriver;
	private long lngPageLoadTimeOut;
	private long lngElementDetectionTimeOut;
	String firstChildWindow;
	String frame;
	Actions myActions;
	Action seriesOfActions;

	public CommonDriver() {
		lngPageLoadTimeOut = 60L;
		lngElementDetectionTimeOut = 30L;
	}

	public void setPageLoadTimeOut(long lngPageLoadTimeOut) {
		this.lngPageLoadTimeOut = lngPageLoadTimeOut;
	}

	public void setElementDetectionTimeOut(long lngElementDetectionTimeOut) {
		this.lngElementDetectionTimeOut = lngElementDetectionTimeOut;
	}

	public void openBrowser(String sBrowserType, String sUrl) {
		try {

			switch (getBrowserTypeIndexed(sBrowserType)) {

			case 1:
				System.setProperty("webdriver.gecko.driver", "C:\\Code\\Java\\Tools\\Selenium\\geckodriver.exe");
				oDriver = new FirefoxDriver();
				break;

			case 2:
				System.setProperty("webdriver.ie.driver", "C:\\Code\\Java\\Tools\\Selenium\\IEDriverServer.exe");
				oDriver = new InternetExplorerDriver();
				break;

			case 3:
				System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
				oDriver = new ChromeDriver();
				break;

			default:
				throw new Exception("Unknow Browser Type = " + sBrowserType);

			}

			if (sUrl.isEmpty()) {

				sUrl = "about:blank";
			}

			oDriver.manage().window().maximize();
			oDriver.manage().deleteAllCookies();
			oDriver.manage().timeouts().pageLoadTimeout(lngPageLoadTimeOut, TimeUnit.SECONDS);
			oDriver.manage().timeouts().implicitlyWait(lngElementDetectionTimeOut, TimeUnit.SECONDS);
			oDriver.get(sUrl);

			Thread.sleep(2000);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// -----------------------------------------------------------------

	public void closeBrowser() {
		try {
			if (oDriver != null) {
				oDriver.quit();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// ------------------------------------------------------------------

	public WebDriver getDriver() {

		return oDriver;
	}

	// ------------------------------------------------------------------
	private int getBrowserTypeIndexed(String sBrowserType) {
		sBrowserType = sBrowserType.toLowerCase().trim();

		if (sBrowserType.isEmpty()) {
			return -1;
		}

		if (sBrowserType.equals("ff") || sBrowserType.equals("firefox") || sBrowserType.equals("mozilla")
				|| sBrowserType.equals("mozilla firefox")) {
			return 1;
		}

		if (sBrowserType.equals("ie") || sBrowserType.equals("explorer") || sBrowserType.equals("internet explorer")) {
			return 2;
		}

		if (sBrowserType.equals("chrome") || sBrowserType.equals("google") || sBrowserType.equals("google chrome")) {
			return 3;
		}

		return -1;
	}

	// ---------------------------------------------------------------------

	public void getUrl(String url) {
		oDriver.get(url);
	}

	public void waitTillElementIsVisible(By oBy, long timeoutSeconds) {
		try {
			WebDriverWait oWait = new WebDriverWait(oDriver, timeoutSeconds);
			oWait.until(ExpectedConditions.visibilityOfElementLocated(oBy));

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// ---------------------------------------------------------------------

	public void waitTillElementIsClickable(By oBy, long timeoutSeconds) {
		try {
			WebDriverWait oWait = new WebDriverWait(oDriver, timeoutSeconds);
			oWait.until(ExpectedConditions.elementToBeClickable(oBy));

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// -------------------------------------------------------------------

	public String savePageSnapshot(String sImagePath) {
		try {

			TakesScreenshot oCamera;
			File oTmpFile, oImageFile;
			oImageFile = new File(sImagePath);

			try {
				Files.deleteIfExists(Paths.get(sImagePath));
			} catch (NoSuchFileException e) {
				System.out.println("No such file/directory exists");
			}

			oCamera = (TakesScreenshot) oDriver;
			oTmpFile = (File) oCamera.getScreenshotAs(OutputType.FILE);
			oCamera.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(oTmpFile, oImageFile);

			return "File got saved";

		} catch (Throwable t) {
			t.printStackTrace();
			return "File already exists";
		}
	}

	// ---------------------------------------------------------------------

	public void setText(By oBy, String sText) {
		try {
			oDriver.findElement(oBy).sendKeys(sText);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// ----------------------------------------------------------------------

	public String getText(By oBy) {
		try {
			System.out.println(oDriver.findElement(oBy).getText());
			return oDriver.findElement(oBy).getText();

		} catch (Throwable t) {
			t.printStackTrace();
			return "No such text found";
		}
	}

	// ---------------------------------------

	public String verifyText(By oBy, String sValue) {
		if (oDriver.findElement(oBy).getText().toString().equalsIgnoreCase(sValue)) {
			System.out.println(oDriver.findElement(oBy).getText().toString());
			return "Text Verified";
		} else {
			return "Verification Failed";
		}
	}

	// ---------------------------------------

	public void clickElement(By oBy) {
		try {
			oDriver.findElement(oBy).click();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// -----------------------------------------

	public void switchToWindow(int x) {
		try {
			firstChildWindow = oDriver.getWindowHandles().toArray()[x].toString();
			System.out.println(firstChildWindow);
			oDriver.switchTo().window(firstChildWindow);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// -----------------------------------------

	public void switchToFrame(String frameID) {
		try {
			oDriver.switchTo().frame(frameID);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// -----------------------------------------

	public void selectParentWindow() {

		oDriver.switchTo().window(oDriver.getWindowHandles().toArray()[0].toString());

	}

	// -----------------------------------------

	public void selectItemInListBox(By oBy, String sItemVisibleText) {
		try {
			Select oListBox;
			oListBox = new Select(oDriver.findElement(oBy));
			oListBox.selectByVisibleText(sItemVisibleText);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// -----------------------------------------

	public void iterateElementsAndClick(By oBy) {
		List<WebElement> resultList = oDriver.findElements(oBy);
		for (WebElement eachResult : resultList) {
			eachResult.click();
		}
	}

	// -----------------------------------------

	public String mouseHover(By oBy) {
		try {
			// in order to click a non visible element

			myActions = new Actions(oDriver);
			myActions.moveToElement(oDriver.findElement(oBy)).build().perform();
			/*
			 * JavascriptExecutor js = (JavascriptExecutor) oDriver;
			 * js.executeScript("arguments[0].click();", we);
			 */

			// seriesOfActions.perform();
			return "Action performed successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}

	}
	// -----------------------------------------

	public String mouseHoverAndClick(By oBy) {
		try {
			// in order to click a non visible element

			WebElement we = oDriver.findElement(By.xpath("//li[@id='wp-admin-bar-logout']/a[1]"));
			myActions = new Actions(oDriver);

			seriesOfActions = myActions.moveToElement(oDriver.findElement(oBy)).moveToElement(we).click().build();
			System.out.println("******");
			seriesOfActions.perform();
			return "Action performed successfully";

		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}

	}

	// -----------------------------------------

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) oDriver;
		// if the element is on top.
		js.executeScript("scroll(250, 0)");
	}

	// -----------------------------------------

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) oDriver;
		// if the element is on bottom.
		js.executeScript("scroll(0,250)");
	}

	// -----------------------------------------

	public void scrollToElement(By oBy) {
		JavascriptExecutor jse;
		jse = (JavascriptExecutor) oDriver;
		int xPoint = oDriver.findElement(oBy).getLocation().x;
		int yPoint = oDriver.findElement(oBy).getLocation().y;
		String command = String.format("window.scrollTo(%d, %d)", xPoint, yPoint);
		jse.executeScript(command);
	}

	// -----------------------------------------

	public void pressTab(String sValue) {
		seriesOfActions = myActions.keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys(sValue).build();
		seriesOfActions.perform();

	}

	// -----------------------------------------

	public void pressEnter() {
		seriesOfActions = myActions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
		seriesOfActions.perform();

	}

	// -----------------------------------------

	public void selectItemByValueInListBox(By oBy, String sItemValue) {
		try {
			Select oListBox;
			oListBox = new Select(oDriver.findElement(oBy));
			oListBox.selectByValue(sItemValue);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// -----------------------------------------

	public void closeCurrentBrowser() {
		oDriver.close();
	}

	// -----------------------------------------

	public void closeAllBrowsers() {
		oDriver.quit();
	}
}
