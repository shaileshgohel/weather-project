package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelWriter {
	
	public String createExcelAsPerLocation(String location, String directoryPath) {
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		Sheet sheet = workbook.createSheet("Sheet1");
		Row topRow = sheet.createRow(0);
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(0);
		cell.setCellValue("Hello");
		//CreateDirectory createDir = new CreateDirectory();
		FileOutputStream fileOut;
		String fileName = directoryPath+"/"+location+".xls";
		try {
			fileOut = new FileOutputStream(fileName);	
			workbook.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileName;


	}

}
