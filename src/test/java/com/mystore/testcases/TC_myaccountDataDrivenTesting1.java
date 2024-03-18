package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetaiils;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.myInformation;
import com.mystore.pageobject.registeredUsersAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_myaccountDataDrivenTesting1 extends BaseClass {

	@DataProvider(name = "LoginDataProvider")

	public String[][] LoginDataProvider()

	{
		// System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreData.xlsx";

		int totalRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int totalColumns = ReadExcelFile.getColumnCount(fileName, "LoginTestData");

		String dataString[][] = new String[totalRows - 1][totalColumns];

		for (int i = 1; i < totalRows; i++) // rows =1,2
		{
			for (int j = 0; j < totalColumns; j++) // columns=0,1,2
			{
				dataString[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		return dataString;
	}

	// -------Test case 2nd --****Verify Login***---------

	@Test(dataProvider = "LoginDataProvider")

	public void VerifyLogin(String userEmail, String userpwd, String expectedUserName) throws IOException {
		logger.info("verify login test Excecution started.");
		indexpage pg = new indexpage(driver);

		pg.clickOnsignIn();

		logger.info("Clicked on sign in");

		myAccount pg2 = new myAccount(driver);

		pg2.enterEmailAddress("userEmail");
		logger.info("Email Entered.");

		pg2.enterPassword("userpwd");

		logger.info("password Entered.");

		pg2.clickOnSignIn();

		logger.info("clicked on sign in button.");

		// Object Creation of Registered user account

		registeredUsersAccount regUser = new registeredUsersAccount(driver);
		String userNameString = regUser.getUserName();

		// **Assert.assertEquals("expectedUserName", userNameString);

		if (userNameString.equals("expectedUserName")) {
			logger.info("VerifyLogin --Passed");

			Assert.assertTrue(true);

			regUser.ClickOnSignOut();

		} else {

			logger.info("VerifyLogin --Failed");
			captureScreenshot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}

	}

	@Test(enabled = false)
	public void verifyRegistrationAndLogin() {
		// open url
		/*
		 * driver.get(url);
		 *
		 * logger.info("Url Opned");
		 */

		indexpage pg = new indexpage(driver);

		pg.clickOnsignIn();

		logger.info("Clicked on sign in");

		myAccount pg2 = new myAccount(driver);

		pg2.enterEmailAddress("nitinkawde31@gmail.com");

		logger.info("Email address entered.");

		pg2.enterPassword("Nitin86");

		logger.info("password Entered.");

		pg2.clickOnSignIn();

		logger.info("clicked on sign in button.");

		pg2.clickOnMyaddrss();

		// Click on my address page

		myInformation information = new myInformation(driver);

		information.clickOnAddnewAddress();
		// Information -account Creation
		accountCreationDetaiils accountcreation = new accountCreationDetaiils(driver);
		/*
		 * accountcreation.selectTitlemr();
		 * accountcreation.entercustomer_firstname("Nitin");
		 * logger.info("entered firstname");
		 * accountcreation.entercustomer_lastname("kawde");
		 * logger.info("entered lastname");
		 *
		 * accountcreation.enter_password("Nitin86");
		 *
		 *
		 * accountcreation.ClickOnSubmitAccount();
		 * logger.info("Clicked on Submit/Registers");
		 */
		accountcreation.enter_Addfirstname("Nitin");

		accountcreation.enter_Addlastname("kawde");

		accountcreation.enter_Address1("pune");

		accountcreation.enter_city("pune");

		accountcreation.enter_HomePhoneNumber("8600603821");

		accountcreation.enter_Postcode("00000");

		accountcreation.enter_MobileNumber("8208836849");

		accountcreation.enter_Alias("Home");

		accountcreation.select_state("Alabama");

		accountcreation.select_Country("United States");

		logger.info("Entered user details on account creation page.");

		accountcreation.ClickOnSubmitAccount();
		logger.info("Clicked on Submit/Registers");

		// Object Creation of Registered user account

		registeredUsersAccount regUser = new registeredUsersAccount(driver);
		String userNameString = regUser.getUserName();

		Assert.assertEquals("Nitin Kawde", userNameString);

	}
}
