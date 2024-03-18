package com.mystore.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();

	String browser = readConfig.getBrowser();

	public void captureScreenshot(WebDriver driver, String testName) throws IOException {

		// Step 1:-- Convert webDriver object to Takescreenshot interfaces
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// Step 2:--Call getscreenshot method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//Screenshot//" + testName + ".png");

		// step 3:--copy image file to destination
		FileUtils.copyFile(src, dest);
	}


	@BeforeClass
	public void settup() {
		String browser = "chrome";

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		// Implicit wait
		}
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

		// For logging
		logger = LogManager.getLogger("Ecommerce");

		// open url
		driver.get(url);

		logger.info("Url Opned");
	}

	@AfterClass
	public void tearDown() {
		// driver.close();
		driver.quit();

	}
}
