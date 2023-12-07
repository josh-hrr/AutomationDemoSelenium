package com.automation.demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//File > Workbook > Sheets > Rows > Cells


public class ReadingExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\data-driven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Hoja1");
		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(1).getLastCellNum();
		
		System.out.println(totalRows + " " +totalColumns);
		
		for(int r = 0; r<=totalRows; r++) { 
			XSSFRow currentRow = sheet.getRow(r); 
			for(int c = 0; c<totalColumns; c++) {
				String value = currentRow.getCell(c).toString();
				System.out.println(value);
			}
		}
		workbook.close();
		file.close();
	}

}
