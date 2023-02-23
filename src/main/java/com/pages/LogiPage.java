package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogiPage {
	
	public LogiPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userNameTextbox;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	private WebElement dashboardLabel;
	
	public void loginToApplication(String userName, String password) {
		userNameTextbox.clear();
		userNameTextbox.sendKeys(userName);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		
		loginButton.click();
	}
	public String getdashboardLabelText() {
		return dashboardLabel.getText();
	}


}
