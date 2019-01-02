package poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExcelHandling {

	WebDriver driver;
	Workbook myBook;
	Sheet mySheet;
	Row myRow;
	Cell myCell;
	String file = "data.xlsx";
	int rowCount;

	String[][] data = new String[4][2];
	String emailId, pass;

	public void loginToFacebook(String userId, String password) {

		try {

			System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	
			driver.get("http://www.facebook.com");
			driver.findElement(By.name("email")).sendKeys(userId);
			driver.findElement(By.name("pass")).sendKeys(password);
			driver.findElement(By.id("loginbutton")).click();
		
			Thread.sleep(1000);
			driver.close();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void readData() {

		try {
			
			myBook = WorkbookFactory.create(new FileInputStream(file));
			mySheet = myBook.getSheetAt(0);
			rowCount = mySheet.getPhysicalNumberOfRows(); // counts rows defined (4)
			System.out.println(rowCount);

			for (int i = 0; i < rowCount; i++) {
				myRow = mySheet.getRow(i);

				for (int j = 0; j < myRow.getLastCellNum(); j++) {
					myCell = myRow.getCell(j);
					CellType type = myCell.getCellType();

					if (type == CellType.NUMERIC) {
						data[i][j] = String.valueOf((long) myCell.getNumericCellValue());
					} else {
						data[i][j] = myCell.getStringCellValue();
					}

				}

			}

		} catch (EncryptedDocumentException e) {
			e.printStackTrace();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void sendDataToFacebook() {
		for (int x = 0; x < data.length; x++) {
			emailId = data[x][0];
			pass = data[x][1];
			loginToFacebook(emailId, pass);
		}
	}

	public static void main(String[] args) {

		TestExcelHandling obj = new TestExcelHandling();
		obj.readData();
		obj.sendDataToFacebook();

	}

}
