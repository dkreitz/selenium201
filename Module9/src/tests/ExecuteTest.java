package tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utils.ReadExcelFile;
import utils.ReadObject;
import utils.UIOperation;

public class ExecuteTest {

	@Test
	public void testLogin() throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\Java\\Tools\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		ReadExcelFile file = new ReadExcelFile();

		ReadObject object = new ReadObject();

		Properties propertiesObj = object.getObjectRepository();

		UIOperation operation = new UIOperation(driver);

		String path = System.getProperty("user.dir") + "\\TestCase.xlsx";
		System.out.println(path);

		Sheet sheet = file.readExcel(System.getProperty("user.dir") + "\\", "TestCase.xlsx", "KeywordFramework");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i < rowCount + 1; i++) {
			
			Row row = sheet.getRow(i);
			
			if (row.getCell(0).toString().length() == 0) {
				
				System.out.println(row.getCell(1).toString() + "----" 
						+ row.getCell(2).toString() + "----"
						+ row.getCell(3).toString() + "----"
						+ row.getCell(4).toString());
				
				operation.perform(propertiesObj, row.getCell(1).toString(), 
						row.getCell(2).toString(), 
						row.getCell(3).toString(), 
						row.getCell(4).toString());
				
			} else {
				
				System.out.println("New Test Case->" + row.getCell(0).toString() + " Started");
				
			}

		}

	}


}
