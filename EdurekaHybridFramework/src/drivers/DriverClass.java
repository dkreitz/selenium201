package drivers;

import java.util.Properties;

import org.openqa.selenium.By;

import commonLibs.ExcelDriver;
import commonLibs.KeywordUtility;
import commonLibs.Utils;

public class DriverClass {

	private static KeywordUtility oKwDriver;
	private static ExcelDriver oExcelDriver;
	private static String sDriverPropertyFile = "C:\\Code\\Java\\Projects\\IntroToSelenium_Workspace\\EdurekaHybridFramework\\src\\conf\\AutomationInput.properties";
	private static Properties oDriverProperties;
	private static String sInputFileFolder;
	private static String sResultFolder;
	private static String sMainDriverInputFile;
	private static String sCurrentTestCaseStatus;

	public static void main(String[] args) {

		oDriverProperties = Utils.getProperties(sDriverPropertyFile);
		sInputFileFolder = oDriverProperties.getProperty("InputFileFolder").trim();
		sMainDriverInputFile = oDriverProperties.getProperty("DriverInputFile").trim();
		sResultFolder = oDriverProperties.getProperty("ResultFolder").trim();
		testSuiteDriver();
		exportToExcel();

	}

	private static void testSuiteDriver() {

		String sTestCaseSheetName, sRunFlag, sRunStatus, sComment;
		String sDriverExcelFile;
		int iRow, iRowCount;

		sDriverExcelFile = sInputFileFolder + "\\" + sMainDriverInputFile;
		oExcelDriver = new ExcelDriver();
		oExcelDriver.openExcelWorkbook(sDriverExcelFile);

		iRowCount = oExcelDriver.getRowCountOfSheet("TestSuite"); // 7
		// iRow is just an integer variable where as the limit is decided by the
		// function to find the number of rows in APache POI
		for (iRow = 2; iRow <= iRowCount + 1; iRow++) {
			sTestCaseSheetName = "";
			sRunFlag = "";
			sRunStatus = "";
			sComment = "";
			sCurrentTestCaseStatus = "Pass";

			sTestCaseSheetName = oExcelDriver.getCellCData("TestSuite", iRow, 2);
			sRunFlag = oExcelDriver.getCellCData("TestSuite", iRow, 3);

			sTestCaseSheetName = sTestCaseSheetName.trim();

			sRunFlag = sRunFlag.toLowerCase().trim();

			if (sRunFlag.equals("yes")) {
				oKwDriver = null;
				sRunStatus = testCaseDriver(sTestCaseSheetName);

				if (sRunStatus == "") {
					if (sCurrentTestCaseStatus == "Pass") {
						sRunStatus = "Pass";
					} else {
						sRunStatus = "Fail";
						sComment = "One or more steps got Failed";
					}

				} else {
					sComment = sRunStatus;
					sRunStatus = "Fail";
				}

			} else {
				sRunStatus = "Skipped";
				sComment = "Because, Run Flag was set to " + sRunFlag;
			}

			oExcelDriver.setCellCData("testSuite", iRow, 4, sRunStatus);
			oExcelDriver.setCellCData("testSuite", iRow, 5, sComment);
		}

	}

	private static String testCaseDriver(String sSheetName) {
		int iRow, iRowCount;

		String sTestCaseDriverreturnvalue = "";

		String sActionKeyword;
		String sObjectLocator;
		String sArgumentValue;
		String sRunStatus;
		String sComment;
		String sReturnValue;
		By oBy;

		try {
			oKwDriver = new KeywordUtility();
			iRowCount = oExcelDriver.getRowCountOfSheet(sSheetName);
			System.out.println("The row count is: " + iRowCount);

			for (iRow = 2; iRow <= iRowCount + 1; iRow++) {
				sActionKeyword = "";
				sObjectLocator = "";
				sArgumentValue = "";
				sRunStatus = "";
				sComment = "";
				sReturnValue = "";
				oBy = null;

				sActionKeyword = oExcelDriver.getCellCData(sSheetName, iRow, 2).trim();
				sObjectLocator = oExcelDriver.getCellCData(sSheetName, iRow, 3).trim();
				sArgumentValue = oExcelDriver.getCellCData(sSheetName, iRow, 4).trim();

				if (sObjectLocator != "" && !sObjectLocator.equals("")) {
					oBy = Utils.getLocatorBy(sObjectLocator);
				}

				if (sActionKeyword == "") {
					sRunStatus = "Skipped";
					sComment = "No Action Keyword";
				} else {
					try {

						sReturnValue = oKwDriver.performAction(sActionKeyword, oBy, sArgumentValue);

						if (sReturnValue.toLowerCase().contains("error")) {
							sRunStatus = "Fail";
							sComment = sReturnValue;
							sReturnValue = "Failure";
							sTestCaseDriverreturnvalue = "Fail";
						} else if (sReturnValue.equals("File already exists")) {
							sRunStatus = "fail";
							sComment = "File Already exists";
							sTestCaseDriverreturnvalue = "Fail";
						} else if (sReturnValue.contains("is present")) {
							sRunStatus = "Pass";
							sComment = "Element is present";
						} else if (sReturnValue.contains("Verification Failed")) {
							sRunStatus = "Fail";
							sComment = "Verification of Url/Title failed";
							sTestCaseDriverreturnvalue = "Fail";
						} else if (sReturnValue.contains("Text")) {
							sRunStatus = "Pass";
							sComment = sReturnValue;
						} else {
							sRunStatus = "pass";
							sReturnValue = "Pass";
							sComment = "The test step passed";
						}

					} catch (Exception e) {
						sRunStatus = "Exception";
						sComment = e.getMessage();
						sCurrentTestCaseStatus = "Fail";
					}
				}

				oExcelDriver.setCellCData(sSheetName, iRow, 5, sRunStatus);
				oExcelDriver.setCellCData(sSheetName, iRow, 6, sReturnValue);
				oExcelDriver.setCellCData(sSheetName, iRow, 7, sComment);

			}

		} catch (Exception e) {
			sTestCaseDriverreturnvalue = e.getMessage();
			sCurrentTestCaseStatus = "Fail";
		}

		return sTestCaseDriverreturnvalue;
	}

	private static void exportToExcel() {
		String sOutputFileName;
		String sDateTimeStamp;

		sDateTimeStamp = Utils.getDateTimeStamp();
		sOutputFileName = sResultFolder + "\\Result as on " + sDateTimeStamp + ".xlsx";

		oExcelDriver.saveAs(sOutputFileName);
	}
}
