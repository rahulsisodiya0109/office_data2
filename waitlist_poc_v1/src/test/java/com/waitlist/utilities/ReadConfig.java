package com.waitlist.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public static Properties pro;

	public ReadConfig() {
		File src = new File("./Configurations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
			// e.printStackTrace();
		}

	}
	
	// for all variable in config file will create method here

	public String getBaseURL() {
		String baseURL = pro.getProperty("baseURL");
		return baseURL;
	}

	public String getLoginPage() {
		String loginPage=pro.getProperty("loginPage");
		return loginPage;
	}
	
	public String getChromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEpath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
}
