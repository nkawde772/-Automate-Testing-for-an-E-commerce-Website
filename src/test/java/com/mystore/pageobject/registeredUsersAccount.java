package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUsersAccount {
	// 1.create object of webdriver
	WebDriver ldriver;
	/// identify webelemets
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement username;

	@FindBy(linkText = "sign out")
	WebElement signOutElement;

	public registeredUsersAccount(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	public void ClickOnSignOut() {
		signOutElement.click();
	}

	public String getUserName() {
		String textString = username.getText();
		return textString;
	}
}
