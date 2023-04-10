package com.waitlist.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.waitlist.pageObjects.LoginPage;
import com.waitlist.utilities.XLUtils;

public class TC_LoginTest_002_DataDriven extends BaseClass {

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	@Test(dataProvider = "LoginData")
	public void loginDDT(String email, String password) throws Exception {

		driver.get(baseURL);
		logger.info("Base URL is opened.");

		LoginPage lp = new LoginPage(driver);

		lp.clickLogin();
		logger.info("Click at Login button.");

		lp.enterCredentials(email, password);
		logger.info("Enter the Email and Password.");

		lp.submitLogin();
		logger.info("Clicked at Submit Login.");

//		following can be used to verify the invalid text on screen
//		boolean iv1=driver.getPageSource().contains("Please enter a valid email address");
//		boolean iv2=driver.getPageSource().contains("Invalid email/password. ");
//		if(iv1==true || iv2==true) {
//		System.out.println("invalid");	
//		}

		if (driver.getTitle().equals("Login | Waitlist Me")) {

			logger.warn("Invalid credentials entered");
			captureScreen(driver, "loginDDT");

		} else if (driver.getTitle().equals("Welcome to Waitlist Me")) {

			captureScreen(driver, "loginDDT");
			lp.clickLogout();
			logger.info("Logout done.");

			Assert.assertTrue(true);
			logger.info("Login test passed.");

		} else {

			captureScreen(driver, "loginDDT");
			lp.clickLogout();
			logger.info("Logout done.");

			Assert.assertTrue(false);
			logger.info("Login test failed.");

		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/waitlist/testData/poc_testData.xlsx";

		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;
	}
}
