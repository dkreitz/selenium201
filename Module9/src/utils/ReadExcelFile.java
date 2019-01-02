package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;

public class ReadExcelFile {
	
	Logger log = Logger.getLogger(ReadExcelFile.class);
	
	public Sheet readExcel(String filePath, String fileName, String z) throws IOException {
		
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = null;
		
		String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length());
		
		if (fileNameExtension.equals(".xslx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else {
			workbook = new XSSFWorkbook(inputStream);
		}
		
		return null;
		
	}
	
}
