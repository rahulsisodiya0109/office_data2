package suite.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.ClusterPage;
import suite.page.DashBoardPage;
import suite.page.FujitsuChecpointsPage;
import suite.page.LoginPage;
import suite.testdata.ClusterTestData;
import suite.testdata.FujitsuTestData;
import suite.testdata.LenovoTestData;
import suite.testdata.LoginTestData;

public class Fujitsu_CheckPoints_Test extends TestBase {

	private FujitsuChecpointsPage fcp;

	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}
	private String getNotificationURL() {
		return getEnv().concat(FujitsuTestData.NOTIFICATION_PAGE);
	}
	private String getClusterPageURL() {
		return getEnv().concat(FujitsuTestData.CLUSTER_PAGE);
	}
	private void getNotificationPage() {

		LoginPage log = new LoginPage(getDriver());

		log.
		getLoginPage(getNotificationURL())
		.enterUserName(LoginTestData.USERNAME)
		.enterpassword(LoginTestData.PASSWORD)
		.clickLoginBtn();

	}
	private void getClusterPage() {
		LoginPage log = new LoginPage(getDriver());
		log.
		getLoginPage(getClusterPageURL())
		.enterUserName(LoginTestData.USERNAME)
		.enterpassword(LoginTestData.PASSWORD)
		.clickLoginBtn();

	}
	private void getAddCluster() {
		ClusterPage cp = new ClusterPage(getDriver());
		cp.clickOnAddCluster()
		.enterHostIP(ClusterTestData.HOST_IP)
		.enterUserName(ClusterTestData.USER_NAME)
		.enterPassword(ClusterTestData.PASSWORD)
		.clickOnSubmit();
	}
	private void getLoginPage() {

		LoginPage log = new LoginPage(getDriver());

		log
		.enterUserName(LoginTestData.USERNAME)
		.enterpassword(LoginTestData.PASSWORD)
		.clickLoginBtn();

	}
	private String getClusterHealthPageUrl() {
		return getEnv().concat(FujitsuTestData.CLUSTER_HEALTH_PAGE);
	}
	private void getClusterHealthLoginPage() {

		LoginPage log = new LoginPage(getDriver());

		log
		.getLoginPage(getClusterHealthPageUrl())
		.enterUserName(LoginTestData.USERNAME)
		.enterpassword(LoginTestData.PASSWORD)
		.clickLoginBtn();
	}
	
	@Test(enabled = false, description = "Verify successfully login with valid credentials", groups = { "wip",
			"Fujitsu_CheckPoints_Test" })
		public void login() {
		
		fcp = new FujitsuChecpointsPage(getDriver());
		fcp.getLoginPage(getPageURL());
		getLoginPage();

		String actual = fcp.getSuccessMessage();


		if (getEnvLang().contains("fujitsu")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE_Fuj);
		} else if (getEnvLang().contains("Lenovo")) {

			Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE_Lenovo);
		}

	}
	
	
		@Test(enabled=false,priority = 0, description = "Verifing The Fujitsu Application Name" , groups = { "wip", "Fujitsu_CheckPoints_Test" })
		public void verifyApplicationName() {
			
			fcp = new FujitsuChecpointsPage(getDriver());
			fcp.getLoginPage(getPageURL());
			getLoginPage();
			
			String actual = fcp.getValidApplicationName();
			System.out.println("Application Name: "+actual);
			if (getEnvLang().contains("fujitsu")) {
	
				if (getBrowserLang().contains("eng")) {
					Assert.assertEquals(actual, FujitsuTestData.APPLICATION_NAME);
				}
				
				if (getBrowserLang().contains("japanese")) {
					Assert.assertEquals(actual,FujitsuTestData.JA_APPLICATION_NAME);
				}
		}
			
			else if (getEnvLang().contains("lenovo"))
			{
				Assert.assertEquals(actual,LenovoTestData.APPLICATION_NAME);
				
			}
			
		}

	/*
	 * Login to the URL
	 *
	 *Verify the Email Address
	 */
	@Test(enabled=false,priority = 0, description = "Verifing The Email Address" , groups = { "wip", "Fujitsu_CheckPoints_Test" })
	public void verifyEmailAddress() {

		fcp = new FujitsuChecpointsPage(getDriver());
		fcp.getLoginPage(getPageURL());
		getNotificationPage();
		
		
		String actual = fcp.getValidEmailAddress();

		System.out.println("Email Address : "+actual);

		if (getEnvLang().contains("fujitsu")) {

			if (getBrowserLang().contains("eng")) {
				Assert.assertEquals(actual, FujitsuTestData.EMAIL_ADDRESS);
			}

			if (getBrowserLang().contains("japanese")) {
				Assert.assertEquals(actual,FujitsuTestData.JA_EMAIL_ADDRESS);
			}
		}
		else if(getEnvLang().contains("lenovo"))
		{
			if (getBrowserLang().contains("eng")) {
				Assert.assertEquals(actual, LenovoTestData.EMAIL_ADDRESS);
			}

			if (getBrowserLang().contains("japanese")) {
				Assert.assertEquals(actual,LenovoTestData.JA_EMAIL_ADDRESS);
			}
			
		}

	}


	@Test(enabled=false,priority = 0, description = "Verifing The Application Name In CLuster Set UP" , groups = { "wip", "Fujitsu_CheckPoints_Test" })
	public void verifyApplicationNameInClusterSetUp() {
		
	fcp = new FujitsuChecpointsPage(getDriver());
	fcp.getLoginPage(getPageURL());
		getClusterPage();
		getAddCluster();
		if(getEnvLang().contains("fujitsu"))
		{
		fcp.getApplicationNameInClusterSetUp();
		}
		else if (getEnvLang().contains("lenovo"))
		{
			
			String actual= fcp.getApplicationNameLenovo();
			
			Assert.assertEquals(actual, LenovoTestData.APPLICATION_NAME);
		}
	
	}
	

	@Test(enabled=true,priority = 0, description = "Verifing The Application Name In CLuster Set UP" , groups = { "wip", "Fujitsu_CheckPoints_Test" })
	public void verifyDocLinks() {
		
		fcp = new FujitsuChecpointsPage(getDriver());
		fcp.getLoginPage(getPageURL());
		getLoginPage();
		fcp.clickOnHelp();
		
		List<WebElement> actual = fcp.getHelpLinks();
		System.out.println(actual);
		
	}
	@Test(enabled=false,priority = 0, description = "Verifing The Help URL " , groups = { "wip", "Fujitsu_CheckPoints_Test" })
	public void VeirfyPopUP() throws InterruptedException {
		fcp = new FujitsuChecpointsPage(getDriver());
		fcp.getLoginPage(getPageURL());
		getLoginPage();
		
		Thread.sleep(1000);
		fcp.clickOnHelp();
		Thread.sleep(1000);
		fcp.clickOnHelpDocument();
		String actual = fcp.getHelpDocumentURL();
		System.out.println(actual);
		if (getEnvLang().contains("fujitsu")) {

			if (getBrowserLang().contains("eng")) {
				Assert.assertEquals(actual, FujitsuTestData.HELPDOCURL);
			}

			if (getBrowserLang().contains("japanese")) {
				Assert.assertEquals(actual,FujitsuTestData.JA_HELPDOCURL);
			}
		}
	}

	
	@Test(enabled=true,priority = 0, description = "Verifing The Help URL ")
	public void VerifyAPI() throws InterruptedException {
		fcp = new FujitsuChecpointsPage(getDriver());
		fcp.getLoginPage(getPageURL());
		getClusterHealthLoginPage();
		
		//fcp.clickOnNode();
		
		
	
		
		
	}
	
}


