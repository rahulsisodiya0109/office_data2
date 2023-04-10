package com.waitlist.testCases;

import org.testng.annotations.Test;

import com.waitlist.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws Exception {

		driver.get(baseURL);
		logger.info("Base URL is opened.");

		LoginPage lp = new LoginPage(driver);

		lp.clickLogin();
		logger.info("Click at Login button.");

		lp.enterCredentials(email, password);
		logger.info("Enter the Email and Password.");

		lp.submitLogin();
		logger.info("Clicked at Submit Login.");

		if (driver.getTitle().equals("Welcome to Waitlist Me")) {
			captureScreen(driver, "loginTest");
			// Assert.assertTrue(true);
			logger.info("Login test passed.");
		} else {
			captureScreen(driver, "loginTest");
			// Assert.assertTrue(false);
			logger.info("Login test failed.");
		}

		driver.get(loginURL);
		logger.info("Return to Login page");
	}

}
