package com.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {

    public void zipMyFile(List<String> sourceFile,String zipFile) {
		
        String outputZipFileName = zipFile+"/ZipOfAllExcel.zip";
        byte[] buffer = new byte[1024];
    	   try {
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputZipFileName));
			for (String file : sourceFile) {
				FileInputStream fis = new FileInputStream(file);
				zos.putNextEntry(new ZipEntry(file));
				int length;
				while((length = fis.read(buffer))>0) {
					zos.write(buffer, 0, length);
				}
				zos.closeEntry();
				fis.close();
			}
			
			zos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    	
    	
    }
}
