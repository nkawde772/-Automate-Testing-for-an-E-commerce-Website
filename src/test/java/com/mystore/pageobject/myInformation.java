package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myInformation {

	// 1.create object of webdriver
	WebDriver ldriver;
	/// identify webelemets
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/a")
	WebElement Addnewaddress;

	public myInformation(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void clickOnAddnewAddress() {
		Addnewaddress.click();

	}
}
