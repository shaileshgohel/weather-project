package com.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public List<String> getExcel() {
        File file = new File(System.getProperty("user.dir")+"/InputData/locations.xls");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheet("Sheet1");
            HSSFRow row = null;
            HSSFCell locationCell = null;;
            List<String> locationDetailsList = new ArrayList<String>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                locationCell = row.getCell(0);
                locationDetailsList.add(locationCell.getStringCellValue());
            }

            return locationDetailsList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
