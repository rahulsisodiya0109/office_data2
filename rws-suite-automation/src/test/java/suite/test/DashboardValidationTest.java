package suite.test;

//import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.ClusterPage;
import suite.page.DashBoardPage;
import suite.page.LoginPage;
import suite.testdata.AppData;
import suite.testdata.ClusterTestData;
//import suite.page.LoginPage;
import suite.testdata.LoginTestData;

public class DashboardValidationTest extends TestBase {

	private DashBoardPage db;
	
	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}

	private String getClusterPageUrl() {
		return getEnv().concat(ClusterTestData.CLUSTER_PAGE);
	}

	private void getClusterLoginPage() {

		LoginPage log = new LoginPage(getDriver());

		log.getLoginPage(getClusterPageUrl())
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
		.clickOnSubmit()
		.clickOnViewCertificate()
		.clikcOnHideCetificate()
		.clickOnYes();

	}

	private void getLoginPage() {

		LoginPage log = new LoginPage(getDriver());

		log.enterUserName(LoginTestData.USERNAME).enterpassword(LoginTestData.PASSWORD).clickLoginBtn();
	}

	/*
	 * Login to the URL
	 * 
	 * Click on Help/Documentation link
	 *
	 */
	@Test(enabled =false, priority = 0, description = "Help Icon Validation on Dashboaed ", groups = { "wip", "ClusterTest" })
	public void HelpIconValidation() {

		db = new DashBoardPage(getDriver());
		db.getLoginPage(getPageURL());
		getLoginPage();

		db.isHelpIconEnable();
		System.out.println("The Help Button is Enabled On the UI");

	}

	/*
	 * Login to the URL Verify the Dashboard string
	 */
	@Test(enabled =false, priority=1, description = "Verify the Dashboard string when No cluster added", groups = { "wip", "ClusterTest" })
	public void clusterMessageValidation() throws InterruptedException {

		db = new DashBoardPage(getDriver());
		db.getLoginPage(getPageURL());
		getLoginPage();

		String actual = db.getAuthenticationMessage();
		Thread.sleep(1000);

		if (getEnvLang().contains("netapp")) {

			if (getBrowserLang().contains("eng")) {
				Assert.assertEquals(actual, ClusterTestData.EXPECTED_CLUSTER_MESSAGE);
			}
			if (getBrowserLang().contains("chinese")) {
				Assert.assertEquals(actual, ClusterTestData.SC_EXPECTED_CLUSTER_MESSAGE);
			}
			if (getBrowserLang().contains("japanese")) {
				Assert.assertEquals(actual, ClusterTestData.JA_EXPECTED_CLUSTER_MESSAGE);
			}
		}

	}

	/*
	 * Login to the URL
	 * 
	 * Click Add Cluster
	 *
	 * @return Cluster Redirection URL
	 */
	@Test(enabled =true, description = "Cluster Redirection URL Validation", groups = { "wip",
			"ClusterTest" })
	public void DashboardClusterAdd() throws InterruptedException {

		db = new DashBoardPage(getDriver());
		db.getLoginPage(getPageURL());
		getLoginPage();

		db.clickOnAddCluster();

		String actual = db.verifyClusterRediretionURL();
		

		if (getEnvLang().contains("netapp")) {

			Assert.assertEquals(actual, AppData.NETAPP.concat("data-sources"));
			
		}
		Thread.sleep(3000);  
	
		}
	/*
	 * Login to the URL
	 * 
	 * Click Add Cluster
	 *
	 * @return Cluster Redirection URL
	 */
	@Test(enabled =true, description = "Intial Cluster Add  Message validation ", groups = { "wip",
			"ClusterTest" })
	public void dashboardClusterAddMessageValidation() throws InterruptedException {

		getClusterLoginPage();
		db = new DashBoardPage(getDriver());
		
		if(getBrowserLang().contains("eng")){
			getAddCluster();
		Thread.sleep(1000);
		String actual = db.verifyAddClusterMessage();
		Assert.assertEquals(actual, ClusterTestData.HOST_IP1.concat(ClusterTestData.EXPECTED_ADD_CLUSTER_MESSAGE));
		}
		else if(getBrowserLang().contains("chinese"))
			Assert.assertTrue(db.verifyClusterDetails());

	}
	
	@Test(enabled = false, description = "Verify the Dasboard dropdown click", groups = { "wip", "LoginTest" })
	public void dashboard_TC_129() throws InterruptedException {
		
		db = new DashBoardPage(getDriver());
		
		db.getLoginPage(getPageURL());
		getLoginPage();
		
		db.clickDashBoard()
		   .clickDropDown()
		   .clickDropDownItem();
		db.isAllClusterVisible();
		System.out.println("All Cluster is visible on dropdown list");
	}

}
