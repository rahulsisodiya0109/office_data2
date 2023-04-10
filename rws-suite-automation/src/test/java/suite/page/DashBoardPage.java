package suite.page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class DashBoardPage extends PageBase {
	
	@FindBy(css = "nwf-globalnav-primary-tools > ul > li:nth-child(2) > a")
	private WebElement helpButton;
	
	@FindBy(css = "ul > li.h-100.show.dropdown > div > button")
	private WebElement clickOnHelpLink;
	
	@FindBy(css = " ui-view > dashboard-header > div > h3")
	private WebElement authorizationMessage;
	
	@FindBy(xpath = "(//span[@class='btn-icon-label'])[1]") //dashboard-header > div > button
	private WebElement clickOnAddCluster;
	
	@FindBy(xpath ="//*[@class='nwf-page-alert-message']/span")
	private WebElement clusterAuthorizationMessage;
	
	@FindBy(xpath  = "/html/body/div[1]/div/ui-view/main-body/div/nav/ng-nwf-left-nav/dx-scroll-view/div[1]/div/div[1]/div[2]/nav/ul/li[1]/a/span")
	private WebElement dashBoardTxtBox;
	
	@FindBy(xpath = "//*[@id='dropdownBasic1']")
	private WebElement dropdown;
	
	@FindBy(xpath = "/html/body/div[1]/div/ui-view/main-body/div/main/ui-view-ng-upgrade/ui-view/dashboard-header/nav/h1/div/div/div[1]")
	private WebElement dropdownItem;
	
	@FindBy(xpath = "//*[@id='dropdownBasic1']")
	private WebElement allCluster;
	
	@FindBy(css = ".ui-grid-contents-wrapper>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(4)")
	private List<WebElement> clusterName;

	
	public DashBoardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * for getting page url 
	 * 
	 * @param pageURL
	 * @return page url of the demo page
	 */
	public DashBoardPage getLoginPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

	public DashBoardPage isHelpIconEnable() {
		
		isWebElementEnabled(helpButton);
		
		return null;
	}
	
	public DashBoardPage clickonHelpIcon() {
		
		clickingElementJS(helpButton);
		return null;
	}
	public DashBoardPage clickOnHelpLink() {
		
		clickingElementJS(clickOnHelpLink);
		return null;
	}

	public String getAuthenticationMessage() {
		
		return getText(authorizationMessage);
		
	}

	public String verifyClusterRediretionURL() {
	
		return (getCurrentURL());
		
	}

	public String verifyAddClusterMessage() {
		
		
		return getText(clusterAuthorizationMessage);
	}
	public DashBoardPage clickOnAddCluster() {
		clickingElementJS(clickOnAddCluster);
		
		return null;
	}

	public String getHelpUrlAuthentication() {
		//newWindow();
		return (getCurrentURL());
	}
	
	public DashBoardPage clickDashBoard() {
		clickingElement(dashBoardTxtBox);
		return this;
	}
	
	
	public DashBoardPage clickDropDown() {
		clickingElement(dropdown);
		return this;
	}
	
	public DashBoardPage clickDropDownItem() {
		clickingElement(dropdownItem);
		return this;
	}

	public String getverifyAllClusterName() {
		return getText(allCluster);
	}
	
	public DashBoardPage isAllClusterVisible() {
		
		isWebElementEnabled(allCluster);
		return null;
	}

	public boolean verifyClusterDetails() {
		getWebElements(clusterName);

		for (int i = 0; i < clusterName.size(); i++) {
			if (clusterName.get(i).getText() != null) {
				System.out.println("ClusterDetails:" + clusterName.get(i).getText());

				return true;
			} else if (clusterName.size() == i)
				return false;
		}
		return false;
	}


}
