package com.waitlist.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.waitlist.pageObjects.SignupPage;

public class TC_SignupTest_003 extends BaseClass {

	@Test
	public void signupTest() throws InterruptedException, IOException {

		driver.get(baseURL);
		logger.info("Base URL is opened.");

		SignupPage sp = new SignupPage(driver);

		sp.signupButton();
		logger.info("Click Sign Up button.");

		sp.searchZip("10001");
		logger.info("Zip entered.");

		sp.businessName("restaurant");
		logger.info("Business name entered.");

		sp.countryName("USA");
		logger.info("Country name entered.");

		sp.searchButton();
		logger.info("Search button clicked.");

		sp.clickSearchResult();
		logger.info("Search result clicked");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);

		sp.saveBusiness();
		logger.info("Business details saved.");
		Thread.sleep(3000); // firefox was crazing with some driver port issue

		sp.userFName("Namrata");
		logger.info("First name entered.");

		sp.userLName("Shah");
		logger.info("Last name entered.");

		String email = "namratashha_" + randomInteger(3) + "@yopmail.com";
		sp.userEmail(email);
		logger.info("Email entered.");

		sp.userPassword("123456");
		logger.info("Password entered.");

		sp.confirmPassword("123456");
		logger.info("Confirm password entered.");

		sp.submitSignup();
		logger.info("Submit signup clicked.");
		Thread.sleep(2000);

		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Welcome to Waitlist Me!']")));

		if (driver.getTitle().equals("Welcome to Waitlist Me")) {
			logger.info("Singnup done.");
			captureScreen(driver, "signupTest");
		} else {
			logger.info("Singnup failed.");
			captureScreen(driver, "signupTest");
		}

		System.out.println("email:" + email);
	}
	
	
	
	

}
