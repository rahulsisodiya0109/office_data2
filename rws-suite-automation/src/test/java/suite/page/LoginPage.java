package suite.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class LoginPage extends PageBase {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting page url of demo page
	 * 
	 * @param pageURL
	 * @return page url of the demo page
	 */
	public LoginPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

	@FindBy(xpath = "*//input[@name='username']")
	private WebElement userNameTxtBox;

	@FindBy(xpath = "*//input[@name='password']")
	private WebElement passwordTxtBox;

	@FindBy(xpath = "*//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(css = "div.nwf-app-title")
	private WebElement successMessage;

	@FindBy(xpath = "*//button[@class='btn btn-primary']")
	private WebElement errorBtn;

	@FindBy(css = "div.modal-body > div")
	private WebElement validationMessage;

	@FindBy(css = "div > header.nwf-login-banner-logo")
	private WebElement logoImage;

	@FindBy(css = "footer.nwf-login-links > a:nth-child(1)")
	private WebElement link;

	@FindBy(css = "footer.nwf-login-links > a:nth-child(2)")
	private WebElement homeLink;

	@FindBy(css = ".nwf-login-body > h2")
	private WebElement validationApplicationName;

	@FindBy(css = "p > a.nwf-is-link-like")
	private WebElement forgotPassword;

	@FindBy(xpath = "*//input[@name='username']")
	private WebElement resetUserNameTxtBox;

	@FindBy(css = "div.nwf-login-button-panel > button.btn.btn-primary.mr-2")
	private WebElement submitBtn;
	
	@FindBy(css = "div.nwf-login-button-panel > button.btn.btn-secondary")
	private WebElement cancelBtn;

	@FindBy(xpath = "//div[contains(text(),'test')]")
	private WebElement infoMessage;

	/**
	 * for entering the user name
	 * 
	 * @param username
	 * @return ob
	 */
	public LoginPage enterUserName(String username) {
		setText(userNameTxtBox, username);
		return this;
	}

	/**
	 * for entering the password
	 * 
	 * @param password
	 * @return object of current class
	 */
	public LoginPage enterpassword(String password) {
		setText(passwordTxtBox, password);
		return this;
	}

	/**
	 * for clicking on login button
	 * 
	 * @return object of current class
	 */
	public LoginPage clickLoginBtn() {
		clickingElement(loginBtn);
		return this;

	}

	/**
	 * for clicking on error button
	 * 
	 * @return object of current class
	 */
	public LoginPage clickErrorBtn() {
		clickingElement(errorBtn);
		return this;

	}

	/**
	 * for getting the success message
	 * 
	 * @return title of product
	 */
	public String getSuccessMessage() {
		return getText(successMessage);
	}

	/**
	 * for getting the authentication validation message
	 * 
	 * @return validation message
	 */
	public String getValidationMessage() {

		return getText(validationMessage);
	}

	/**
	 * for getting image is displayed or not
	 * 
	 * @return true if image is display
	 */

	public boolean getImageLogo() {

		return getWebElement(logoImage).isDisplayed();
	}

	/**
	 * for click on netappSupport link
	 * 
	 * @return object of current class
	 */

	public LoginPage clkOnSupportLink() {

		clickingElementJS(link);
		return this;

	}

	/**
	 * for getting the NetappSupportURL message
	 * 
	 * @return current page URL
	 */

	public String getNetAppPageURL() {

		closePreviousTab();
		return getCurrentURL();

	}

	/**
	 * for click on netappHome link
	 * 
	 * @return object of current class
	 */

	public LoginPage clkOnHomeLink() {

		clickingElementJS(homeLink);
		return this;

	}

	/**
	 * for click on forgotPassword link
	 * 
	 * @return object of current class
	 */

	public LoginPage clkOnForgotPasswordLink() {

		clickingElementJS(forgotPassword);
		return this;

	}

	/**
	 * for getting the NetApp Home message
	 * 
	 * @return current page URL
	 */

	public String getNetAppHomeURL() {

		closePreviousTab();
		return getCurrentURL();

	}

	public String getNetAppApplicationName() {
		// TODO Auto-generated method stub
		closePreviousTab();
		return getText(validationApplicationName);
	}

	public LoginPage enterRestetUserName(String restname) {
		setText(resetUserNameTxtBox, restname);
		return this;

	}

	public LoginPage clickOnSubmitBtn() {
		clickingElement(submitBtn);
		return this;
	}

	public String getInfoMessage() {

		return getText(infoMessage);
	}
	
	public LoginPage clickOnCancelBtn() {
		clickingElement(cancelBtn);
		return this;
	}


}
