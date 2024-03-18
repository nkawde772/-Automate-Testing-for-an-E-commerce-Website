package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;

	String path = "C:\\Users\\DELL\\OneDrive\\Desktop\\New folder\\WEB_GUI_Exam\\Ecommerce\\Configuration\\Config.properties";

	// constructer
	public ReadConfig() {
		try {
			properties = new Properties();

			FileInputStream fiS = new FileInputStream(path);
			properties.load(fiS);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/// Create methode for URL
	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");

		if (value != null) {
			return value;
		} else {
			throw new RuntimeException("Url not specified in config file.");
		}
	}

	/// Create methode for Browser
	public String getBrowser() {
		String value = properties.getProperty("browser");

		if (value != null) {
			return value;
		} else {
			throw new RuntimeException("Url not specified in config file.");
		}
	}
}
