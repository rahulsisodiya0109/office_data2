package com.waitlist.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[text()='Login']")
	@CacheLookup
	WebElement loginButton;

	@FindBy(id = "email")
	@CacheLookup
	WebElement email;

	@FindBy(id = "password")
	@CacheLookup
	WebElement pass;
	
	@FindBy(xpath = "//input[@class='sign_up_btn_s1 login_but']")
	@CacheLookup
	WebElement submitLogin;
	
	@FindBy(id="greeting")
	@CacheLookup
	WebElement logoutHeader;
	
	@FindBy(xpath="//a[@id='greeting']/following-sibling::ul/li[4]/a")
	@CacheLookup
	WebElement logout;
	
	@FindBy(xpath="//label[text()='Please enter a valid email address']")
	@CacheLookup
	WebElement invalidCreds1;
	
	@FindBy(xpath="//div[text()='Invalid email/password. ']")
	@CacheLookup
	WebElement invalidCreds2;
	

	public void clickLogin() throws Exception {
		loginButton.click();
	}

	public void enterCredentials(Object id, Object password) throws Exception {
		email.clear();
		pass.clear();
		email.sendKeys((String) id);
		pass.sendKeys((String) password);
	}

	public void submitLogin() throws Exception {
		submitLogin.click();
	}
	
	public void clickLogout() {
		
		new WebDriverWait(ldriver, 10).until(ExpectedConditions.visibilityOf(logoutHeader)).click();
		new WebDriverWait(ldriver, 10).until(ExpectedConditions.visibilityOf(logout)).click();
		
//		logoutHeader.click();
//		logout.click();
	}
	
	//following method not used in test class, instead used the other approach
	public boolean enterValidCreds() {
		if(invalidCreds1.isDisplayed() || invalidCreds2.isDisplayed()) {
			return true;
		}
		return false;
	}
}
