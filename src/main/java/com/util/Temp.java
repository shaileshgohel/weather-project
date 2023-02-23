package com.util;

import java.util.ArrayList;
import java.util.List;

public class Temp {
	public static void main(String[] args) {
		
		ExcelReader excelReader = new ExcelReader();
		CreateDirectory createDir = new CreateDirectory();
		ExcelWriter excelWrite = new ExcelWriter();
		ZipFile zipFile = new ZipFile();
		SendEmailWithAttachment sendEmail = new SendEmailWithAttachment();
		
		List<String> locationList = excelReader.getExcel();
		List<String> fileNameList = new ArrayList<>();
		String directoryPath = createDir.createDirectoyAsPerCurrentTime();
		for (String location : locationList) {
			fileNameList.add(excelWrite.createExcelAsPerLocation(location, directoryPath));
		}
		
		zipFile.zipMyFile(fileNameList, directoryPath);
		sendEmail.sendAnEmail();
		
		
		
	}
}
