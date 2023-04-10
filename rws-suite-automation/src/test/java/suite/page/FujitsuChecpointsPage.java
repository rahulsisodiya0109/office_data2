package suite.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class FujitsuChecpointsPage extends PageBase {
	
	@FindBy(css = "a > nwf-app-title > div > div")
	private WebElement ApplicationName;
	
	@FindBy(xpath = "//*[@id='fromAddress']")
	private WebElement EmailAddress;
	
	@FindBy(css = "article > p:nth-child(1)")
	private WebElement ApplicationNameInClusterSetUp;
	
	@FindBy(css = "nwf-globalnav-primary-tools > ul > li:nth-child(2) > a")
	private WebElement clickOnHelp;
	
	@FindBy(css = "css:dropdown-menu show")    //css:dropdown-menu show
	private WebElement HelpLinks;
	
	@FindBy(css = "ul > li.h-100.show.dropdown > div > button")
	private WebElement clickOnHelpDOC;
	
	@FindBy(css = "ul > li.h-100.show.dropdown > div > a")
	private WebElement clickOnAPI;
	
	@FindBy(css = "//a[@data-netapp-id='leftnav-item-navigation:leftnav.nodesperf-link']/child::span")    //#gwt-debug-CLUSTER_DETAILS_TAB_ITEM__nodes > a.x-tab-right > em > span > span
	private WebElement clickNode;
	
	@FindBy(css = "div.nwf-app-title")
	private WebElement successMessage;
	
	public FujitsuChecpointsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * for getting page url 
	 * 
	 * @param pageURL
	 * @return page url of the demo page
	 */
	public FujitsuChecpointsPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

	public String getValidApplicationName() {
		
		return getText(ApplicationName);
		
	}

	public String getValidEmailAddress() {
		getWebElement(EmailAddress);
		return(EmailAddress.getAttribute("value"));
	}

	public String getApplicationNameInClusterSetUp() {
		getWebElement(ApplicationNameInClusterSetUp);
		String Expected = ApplicationNameInClusterSetUp.getText();
		if(Expected.contains("ActiveIQ Unified Manager")) {
			System.out.println("The ActiveIQ Unififed Manager is presenet in the UI");
		}else {
			System.out.println("The ActiveIQ Unififed Manager is not present in the UI");
		}
		return "Active Unified Manager";

	}

	public FujitsuChecpointsPage clickOnHelp() {
		getWebElement(clickOnHelp);
		clickingElementJS(clickOnHelp);
		return null;
	}

	public List<WebElement> getHelpLinks() {
		getWebElement(HelpLinks);
		List<WebElement> Links =getWebElements((List<WebElement>) HelpLinks);
		return Links;
		
	}

	public void clickOnHelpDocument() {
		clickingElementJS(clickOnHelpDOC);
		
	}

	public String getHelpDocumentURL() {
		newWindow();
		return (getCurrentURL());
	}

	public String getAPIDoc() {
		closePreviousTab();
		return (getCurrentURL());
	}

	public void clickOnAPI() {
		getWebElement(clickOnAPI);
		clickingElementJS(clickOnAPI);
		
	}

	public void clickOnNode() {
		waitForPageLoadComplete();
		clickingElementJS(clickNode);
		
	}

	public String getApplicationNameLenovo() {
		return getText(ApplicationNameInClusterSetUp);
	}

	public String getSuccessMessage() {
		return getText(successMessage);
	}

}
