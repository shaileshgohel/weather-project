package com.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.InitDriver;
import com.pages.LogiPage;

public class LoginTest extends InitDriver{
	
	@Test
	public void loginToApplication() throws InterruptedException {
		LogiPage loginPage = new LogiPage(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage.loginToApplication("Admin", "admin123");
		Thread.sleep(3000);
		Assert.assertEquals(loginPage.getdashboardLabelText(), "Dashboard");
	}
	
	

}
