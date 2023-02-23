package com.util;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateDirectory {
	
	public String createDirectoyAsPerCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"); 
	    String formattedDateTime = now.format(formatter); 
	    File directory = new File(System.getProperty("user.dir")+"/OutputData/"+formattedDateTime); 
	    if (!directory.exists()) {
	      directory.mkdir(); 
	      System.out.println("Directory created: " + directory.getAbsolutePath());
	    } else {
	      System.out.println("Directory already exists: " + directory.getAbsolutePath());
	    }
	    return directory.getAbsolutePath();
	}

}
