package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
    // 1.create object of webdriver
    WebDriver ldriver;

    /// identify webelemets
    @FindBy(id = "email")
    WebElement EmailId;

    @FindBy(id = "passwd")
    WebElement passElement;

    @FindBy(id = "SubmitLogin")
    WebElement SignIn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/ul/li[4]/a/span")
    WebElement myaddress;

    // @FindBy(xpath = "//*[@id=\"center_column\"]/div/a")
    // WebElement Addnewaddress;

    public myAccount(WebDriver rdriver) {

	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);

    }

    // public void clickOnAddnewAddress() {
    // Addnewaddress.click();

    // }

    public void clickOnMyaddrss() {
	myaddress.click();
    }

    public void clickOnSignIn() {
	SignIn.click();
    }

    // identfy action on webelement
    public void enterEmailAddress(String emailAdd) {
	EmailId.sendKeys(emailAdd);
    }

    public void enterPassword(String passAdd) {
	passElement.sendKeys(passAdd);
    }

}
