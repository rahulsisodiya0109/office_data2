package suite.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class ClusterPage extends PageBase {

	private WebDriver driver;

	@FindBy(css = "nwf-grid-params-controller > nav:nth-child(1) > ul > li:nth-child(1) > button > span")
	private WebElement addBtn;

	@FindBy(xpath = "//*[@id='hostName']")
	private WebElement hostIPTextBox;

	@FindBy(xpath = "//*[@id='userName']")
	private WebElement userTextBox;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement passwordTextBox;

	@FindBy(css = "button.btn.btn-primary > span:nth-child(1)")
	private WebElement submitBtn;

	@FindBy(css = "div:nth-child(1) > div > div > div > div.modal-footer > button.btn.btn-primary")
	private WebElement yesBtn;

	@FindBy(css = "div.modal-header.is-critical > span")
	private WebElement authorizationMessage;

	@FindBy(css = " div.modal-body > div:nth-child(1) > label")
	private WebElement authorizationMessage1;

	@FindBy(css = "div.modal-body > article > p.cluster-cert-outer-body > button")
	private WebElement viewCetrificateLink;

	@FindBy(css = "div.modal-body > article > p.cluster-cert-outer-body > button")
	private WebElement hideCertificateLink;

	@FindBy(css = "div.modal-footer > button.btn.btn-link")
	private WebElement cacelBtn;

	@FindBy(css = "div.modal-body>span")
	private WebElement waringAuthorizationMessage;

	@FindBy(css = ".ui-grid-contents-wrapper>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div>div:nth-child(4)")
	private List<WebElement> clusterName;

	@FindBy(css = ".nwf-page-alert-message >span")
	private WebElement alertMessage;

	public ClusterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * for getting page url
	 * 
	 * @param pageURL
	 * @return page url of the demo page
	 */
	public ClusterPage getClusterPage(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

	/**
	 * for to clicking on Add button
	 *
	 * return to enter all the required details to add cluster
	 */
	public ClusterPage clickOnAddCluster() {

		clickingElementJS(addBtn);
		return this;
	}

	/**
	 * for to enter the SM Cluster_IP
	 * 
	 *
	 */
	public ClusterPage enterHostIP(String hostIp) {

		setText(hostIPTextBox, hostIp);
		return this;
	}

	/**
	 * for to enter the user_Name
	 * 
	 */
	public ClusterPage enterUserName(String userName) {

		setText(userTextBox, userName);
		return this;
	}

	/**
	 * for to enter the password
	 * 
	 */

	public ClusterPage enterPassword(String password) {

		setText(passwordTextBox, password);
		return this;
	}

	/**
	 * for clicking on Submit button
	 * 
	 * return the confirmation page
	 */
	public ClusterPage clickOnSubmit() {

		clickingElement(submitBtn);
		return this;

	}

	/**
	 * for to fetch the banner/authorization message
	 * 
	 *
	 */

	public String getAuthorizatonMessage() {

		return getText(authorizationMessage);
	}

	/**
	 * for to fetch the banner/authorization message
	 * 
	 *
	 */

	public String getAuthorizatonMessage_1() {

		return getText(authorizationMessage1);
	}

	/**
	 * for clicking on yes button to add cluster
	 * 
	 * return cluster will be added
	 */

	public void clickOnYes() {
		clickingElementJS(yesBtn);

	}

	/**
	 * for Click on View Certificate
	 * 
	 * return Cluster_IP Details
	 */

	public ClusterPage clickOnViewCertificate() {

		clickingElement(viewCetrificateLink);
		return this;
	}

	/**
	 * for click on Hide Certificate
	 * 
	 *
	 */

	public ClusterPage clikcOnHideCetificate() {

		clickingElement(hideCertificateLink);
		return this;

	}

	/**
	 * for Click on Cancel button
	 * 
	 * return alert page
	 */

	public void clickOnCancel() {

		clickingElement(cacelBtn);

	}

	/**
	 * for Verify the whether need to cancel or not
	 * 
	 * return alert message
	 */

	public String getWaringAuthorizationMessage() {

		return getText(waringAuthorizationMessage);

	}

	/**
	 * for Verify the ClusterIP added or Not
	 * 
	 * return true if match the cluster IP
	 */

	public Boolean verifyClusterDetails() {

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

	/**
	 * get Alert Message
	 * 
	 * return alert message
	 */

	public String getAlertMessage() {

		return getText(alertMessage);
	}

}
