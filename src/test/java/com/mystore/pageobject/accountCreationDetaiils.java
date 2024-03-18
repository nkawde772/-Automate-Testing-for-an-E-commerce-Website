package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetaiils {
	// 1.create object of webdriver
	WebDriver ldriver;
	/// identify webelemets
	/*
	 * @FindBy(id = "id_gender1") // Title Mr WebElement titilemr;
	 *
	 * @FindBy(xpath = "//*[@id=\"customer_firstname\"]") WebElement
	 * customer_firstname;
	 *
	 * @FindBy(xpath = "//*[@id=\"customer_lastname\"]") WebElement
	 * customer_lastname;
	 *
	 * @FindBy(id = "passwd") WebElement password;
	 */

	@FindBy(id = "firstname")
	WebElement Addfirstname;

	@FindBy(id = "lastname")
	WebElement Addlastname;

//Address
	@FindBy(id = "address1")
	WebElement Address1;

//City
	@FindBy(id = "city")
	WebElement City;

//uniform-id_state
	@FindBy(id = "id_state")
	WebElement State;

//postcode
	@FindBy(id = "postcode")
	WebElement postcode;

//country
	@FindBy(id = "id_country")
	WebElement Country;

	@FindBy(id = "phone")
	WebElement HomePhonNumber;

//Mobile Number
	@FindBy(id = "phone_mobile")
	WebElement MobileNumber;

//Alias for resferences
	@FindBy(id = "alias")
	WebElement Alias;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement submitAccount;

	public accountCreationDetaiils(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// Methods for actions on elements
//identfy action to be performed on web element

	public void ClickOnSubmitAccount() {
		submitAccount.click();
	}

	public void enter_Addfirstname(String Afname) {
		Addfirstname.clear();
		Addfirstname.sendKeys(Afname);
	}

	public void enter_Addlastname(String lfname) {
		Addlastname.clear();
		Addlastname.sendKeys(lfname);
	}

	public void enter_Address1(String Add) {
		Address1.sendKeys(Add);
	}

	public void enter_Alias(String alias) {
		Alias.sendKeys(alias);
	}

	public void enter_city(String CTY) {
		City.sendKeys(CTY);
	}

	public void enter_HomePhoneNumber(String Home) {
		HomePhonNumber.sendKeys(Home);
	}

	// public void enter_password(String pas) {
	// password.sendKeys(pas);

	// }

	public void enter_MobileNumber(String phnumber) {
		MobileNumber.sendKeys(phnumber);
	}

	public void enter_Postcode(String Postcode) {
		postcode.sendKeys(Postcode);
	}

	/*
	 * public void entercustomer_firstname(String fname) {
	 *
	 * customer_firstname.sendKeys(fname); }
	 *
	 * public void entercustomer_lastname(String lname) { //
	 * customer_lastname.sendKeys(lname); }
	 */
	public void select_Country(String text) {
		Select cntry = new Select(Country);
		cntry.selectByVisibleText(text);
	}

	public void select_state(String statename) {
		Select obj = new Select(State);
		obj.selectByVisibleText(statename);
	}

	// public void selectTitlemr() {
	// titilemr.click();
////	}

}
