package com.mystore.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	// Create Excel workbook,excelSheet,rows,cell
	public static FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet exceSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	// Create excel filename ,Sheetname,Rowno,CellNo
	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {

		try {
			inputStream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputStream);
			exceSheet = workbook.getSheet(sheetName);
			cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

			workbook.close();

			return cell.getStringCellValue();

		}

		catch (Exception e) {
			return "";
		}
	}

	/// get Total number of Column Count
	public static int getColumnCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);

			// Create XSSFWoekbook Class object for excel file manipulation

			workbook = new XSSFWorkbook(inputStream);
			exceSheet = workbook.getSheet(sheetName);

			// get Total number of rows
			int totalNoColumn = exceSheet.getLastRowNum() + 1;

			workbook.close();

			return totalNoColumn;
		}

		catch (Exception e)

		{
			return 0;
		}
	}

	/// get Total number of Row Count
	public static int getRowCount(String fileName, String sheetName) {
		try {
			inputStream = new FileInputStream(fileName);

			// Create XSSFWoekbook Class object for excel file manipulation

			workbook = new XSSFWorkbook(inputStream);
			exceSheet = workbook.getSheet(sheetName);

			// get Total number of rows
			int totalRows = exceSheet.getRow(0).getLastCellNum();

			workbook.close();

			return totalRows;
		}

		catch (Exception e)

		{
			return 0;
		}
	}
}
