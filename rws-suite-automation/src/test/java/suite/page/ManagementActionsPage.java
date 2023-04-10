package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.xjc.Driver;

import suite.base.PageBase;

public class ManagementActionsPage extends PageBase {
	
	@FindBy(xpath = "//*[@id='cluster-login-banner-disabled-header']/div/div")
	private WebElement FixAllEnabled;
	
	@FindBy(css = "#cluster-login-banner-disabled-header > div > div > fix-it > div > button")
	private WebElement clickOnFixAllBtn;
	
	@FindBy(xpath = "div.modal-footer > button.btn.btn-primary")
	WebElement clickOnFixAll;
	
	@FindBy(xpath = "//*[@id='cluster-login-banner-disabled-header']/div/div/fix-it/div/div/button")
	private WebElement clickOnDropDown;
	
	@FindBy(xpath ="//*[@class='dropdown']/div/button")
	private WebElement DismissAllEnabled;
	
	@FindBy(css = "body > div.dropdown > div > button")
	private WebElement clickOnDismissAll;
	
	@FindBy(xpath = "div.modal-footer > button.btn.btn-primary")
	private WebElement clickOnOk;
	
	@FindBy(css = "ui-view-ng-upgrade > ui-view > dashboard-header > div > h2")
	private WebElement discoveryTimeMessage;
	
	public ManagementActionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	                       
	/**
	 * for getting page url 
	 * 
	 * @param pageURL
	 * @return page url
	 */
	public ManagementActionsPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}
	public ManagementActionsPage fixAllIsEnableOrNot() {
		
		isWebElementEnabled(FixAllEnabled);
		return null;
	}

	public ManagementActionsPage clickOnFixAllBtn() {
		getWebElement(clickOnFixAllBtn);
		clickingElement(clickOnFixAllBtn);
		return null;
	}

	public void clickOnFixAll() {
		
		clickingElement(clickOnFixAll);
		
	}

	public ManagementActionsPage clickOnDropdown() {
		getWebElement(clickOnDropDown);
		clickingElementJS(clickOnDropDown);
		return null;
	}

	public ManagementActionsPage isDismisssAllEnabled() {
		
		isWebElementEnabled(DismissAllEnabled);
		return null;
	}

	public ManagementActionsPage clickOnDismissAll() {
		clickingElementJS(clickOnDismissAll);
		return null;
		
	}

	public void clickOnOK(){
		
		clickingElementJS(clickOnOk);
		
	}

	public String getDiscoveryTime() {
		
		return getText(discoveryTimeMessage);
	}

	 
}
