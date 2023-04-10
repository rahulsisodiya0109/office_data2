package suite.page;

import java.util.List;
import java.lang.String;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class AboutScreen extends PageBase {

	public AboutScreen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public AboutScreen clickOnHelpLink() {
		clickingElementJS(link);
		return this;

	}

	public AboutScreen clickOnAboutLink() {
		clickingElementJS(aboutLink);
		return this;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return getText(validateAppName);
	}

	public String getBuildVersionNumber() {

		return getText(buildVersionInfo);
	}

	public Boolean verifyBuildVersion(CharSequence buildVersion) {

		/*
		 * 1. create a list of file dir 2. Iterate untile list.size 3. return
		 * true, if the index value is equal to buildVersion 4. return false, if
		 * index value is equal to filesize
		 */
		getWebElements(fileDir);

		for (int i = 0; i < fileDir.size(); i++) {
			System.out.println("Version:" + buildVersion);

			if (fileDir.get(i).getText().contains(buildVersion)) {

				return true;
			} else if (fileDir.size() == i)
				return false;

		}
		return false;

	}

	public String getCopyrightDetails() {

		return getText(copyrightDetails);
	}

	public Boolean getNetAppLogo() {

		return getWebElement(logoImage).isDisplayed();
	}

	public Boolean getOEMLogo() {

		return getWebElement(logoImageOem).isDisplayed();
	}

	@FindBy(css = "a.icon.file")
	private List<WebElement> fileDir;

	@FindBy(css = "ul > li:nth-child(2) > a.nwf-admin-nav-menu-item.dropdown-toggle")
	private WebElement link;

	@FindBy(xpath = "//*[@id='aboutModal']")
	private WebElement aboutLink;

	@FindBy(css = "div.modal-body > div:nth-child(2) > div")
	private WebElement validateAppName;

	@FindBy(css = "div.modal-body > div:nth-child(3) > span")
	private WebElement buildVersionInfo;

	@FindBy(css = "div.modal-body > div.nwf-about-copyright-info.small.text-monospace")
	private WebElement copyrightDetails;

	@FindBy(css = "div.nwf-about-logo")
	private WebElement logoImage;
	
	@FindBy(css = "div.modal-body > img")
	private WebElement logoImageOem;

	public AboutScreen getPageURL(String pageURL) {
		NavigatetoPage(pageURL);
		return this;
	}

}
