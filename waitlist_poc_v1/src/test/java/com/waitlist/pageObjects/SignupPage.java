package com.waitlist.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

	WebDriver ldriver;

	public SignupPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Sign Up']")
	@CacheLookup
	WebElement signupButton;

	@FindBy(how = How.XPATH, using = "//input[@id ='searchzip']")
	@CacheLookup
	WebElement searchZip;

	@FindBy(xpath = "//input[@placeholder = 'Business name']")
	@CacheLookup
	WebElement businessName;

	@FindBy(xpath = "//select[@id='plan_id_search']")
	@CacheLookup
	WebElement countryName;

	@FindBy(id = "searchbutton")
	@CacheLookup
	WebElement searchButton;

	@FindBy(xpath = "//*[@id='restaurant-search-list']/div[1]/ul[1]/li[1]/div[1]/a")
	@CacheLookup
	WebElement searchResult; // just selecting the first search since there is no multi search right now

	@FindBy(xpath = "//input[@value='Save my Business']")
	@CacheLookup
	WebElement saveBusiness;

	@FindBy(xpath = "//input[@id='user_form_name']")
	@CacheLookup
	WebElement userFName;

	@FindBy(xpath = "//input[@id='user_form_last_name']")
	@CacheLookup
	WebElement userLName;

	@FindBy(xpath = "//input[@id='user_form_email']")
	@CacheLookup
	WebElement userEmail;

	@FindBy(xpath = "//input[@id='user_form_password']")
	@CacheLookup
	WebElement userPassword;

	@FindBy(xpath = "//input[@id='user_form_password_confirmation']")
	@CacheLookup
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='signup_button']")
	@CacheLookup
	WebElement submitSignup;

	public void signupButton() {
		signupButton.click();
	}

	public void searchZip(String zip) {
		searchZip.sendKeys(zip);

	}

	public void businessName(String bName) {
		businessName.sendKeys(bName);
	}

	public void countryName(String country) {
		new Select(countryName).selectByVisibleText(country);
	}

	public void searchButton() {
		searchButton.click();
	}

	public void clickSearchResult() {
		searchResult.click();
	}

	public void saveBusiness() {
		saveBusiness.click();
	}

	public void userFName(String fName) {
		userFName.sendKeys(fName);
	}

	public void userLName(String lName) {
		userLName.sendKeys(lName);
	}

	public void userEmail(String email) {
		userEmail.sendKeys(email);
	}

	public void userPassword(String password) {
		userPassword.sendKeys(password);
	}

	public void confirmPassword(String password) {
		confirmPassword.sendKeys(password);
	}

	public void submitSignup() {
		submitSignup.click();
	}
}
