package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexpage {
    // 1.create object of webdriver
    WebDriver ldriver;
    /// identify webelemets
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signin;

    public indexpage(WebDriver rdriver) {

	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
    }

    // identfy action on webelement

    public void clickOnsignIn() {
	signin.click();
    }
}
