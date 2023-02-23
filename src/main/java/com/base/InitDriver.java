package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class InitDriver {
	
	public WebDriver driver; 
	
	@BeforeSuite
	public void init() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}

}
