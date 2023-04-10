package suite.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.ClusterPage;
import suite.page.LoginPage;
import suite.testdata.ClusterTestData;
import suite.testdata.HomeTestData;
import suite.testdata.LoginTestData;

public class ClusterTest extends TestBase {

	private ClusterPage cp;

	private String getLoginPageURL() {
		return getEnv();
	}

	private String getClusterPageUrl() {
		return getEnv().concat(ClusterTestData.CLUSTER_PAGE);
	}
	private void getLoginPage() {


		LoginPage log = new LoginPage(getDriver());

		log.
		getLoginPage(getClusterPageUrl())
		.enterUserName(LoginTestData.USERNAME)
		.enterpassword(LoginTestData.PASSWORD)
		.clickLoginBtn();

	}

	/* for to add cluster 
	 * 
	 * @param SM Cluster IP,User_Name,Password
	 * 
	 * @return SM CLuster_IP is added
	 */
	
	/*
	 *  @param Add Host_IP
	 */

	private void Add(String hostIP) {
		cp.clickOnAddCluster()
		.enterHostIP(hostIP)
		.enterUserName(ClusterTestData.USER_NAME)
		.enterPassword(ClusterTestData.PASSWORD)
		.clickOnSubmit()
		.clickOnViewCertificate()
		.clikcOnHideCetificate()
		.clickOnYes();
		String actual= cp.getAlertMessage();
		Assert.assertEquals(actual, ClusterTestData.HOST_IP.concat(ClusterTestData.EXPECTED_ADD_CLUSTER_MESSAGE));
	}

	@Test(enabled=true, description = "Verify successfully Cluster SetUp", groups = { "wip", "ClusterTest" })
	public void addCluster() throws InterruptedException {
		getLoginPage();

		cp = new ClusterPage(getDriver());
		
		if(getBrowserLang().contains("eng")){
		Add(ClusterTestData.HOST_IP);
		}
		
		else if(getBrowserLang().contains("chinese")){
		Assert.assertTrue(cp.verifyClusterDetails());
		}
		else if(getBrowserLang().contains("japanese")){
			Assert.assertTrue(cp.verifyClusterDetails());
			}
		Thread.sleep(2000);
	}
	
	@Test(enabled=false,  description = "Verify the Error Message while not adding cluster IP",  groups = { "wip", "ClusterTest" })
	public void addClusterWithOutClusterIP() throws InterruptedException {

		getLoginPage();

		cp = new ClusterPage(getDriver());
		cp.clickOnAddCluster()
		.enterUserName(ClusterTestData.USER_NAME)
		.enterPassword(ClusterTestData.PASSWORD)
		.clickOnSubmit();
		
		Thread.sleep(1000);
		String actual = cp.getAuthorizatonMessage_1();
		System.out.println(actual);
		
		if (getBrowserLang().contains("eng")) {
			Assert.assertEquals(actual, ClusterTestData.EXPECTED_CLUSTTER_AUTHORIZATHION_MESSAGE);
		}
		if (getBrowserLang().contains("chinese")) {
			Assert.assertEquals(actual, ClusterTestData.SC_EXPECTED_CLUSTTER_AUTHORIZATHION_MESSAGE);
		}
		if (getBrowserLang().contains("japanese")) {
			Assert.assertEquals(actual, ClusterTestData.JA_EXPECTED_CLUSTTER_AUTHORIZATHION_MESSAGE);
		}
	}


	/*
	 * For to verify the warning message
	 * 
	 * @param SM Cluster IP,User_Name,Password
	 * 
	 * @return Warning message
	 */

	@Test(enabled=false,  description = "Verify Warning Message",  groups = { "wip", "ClusterTest" })
	public void verifyWarningMessage() throws InterruptedException {
		getLoginPage();

		cp = new ClusterPage(getDriver());
		cp.clickOnAddCluster()
		.enterHostIP(ClusterTestData.HOST_IP)
		.enterUserName(ClusterTestData.USER_NAME)
		.enterPassword(ClusterTestData.PASSWORD)
		.clickOnCancel();

		Thread.sleep(1000);
		String actual = cp.getWaringAuthorizationMessage();
		

		if (getBrowserLang().contains("eng")) {
			assertEquals(actual, ClusterTestData.EXPECTED_WARNING_MESSAGE);
		}
		if (getBrowserLang().contains("chinese")) {
			assertEquals(actual, ClusterTestData.SC_EXPECTED_WARNING_MESSAGE);
		}
		if (getBrowserLang().contains("japanese")) {
			assertEquals(actual, ClusterTestData.JA_EXPECTED_WARNING_MESSAGE);
		}
	
		

	}
	
	@Test(enabled=true, description = "Verify Error Message for add existing cluster IP", groups = { "wip", "ClusterTest" })
	public void addExistingCluster() throws InterruptedException {
		getLoginPage();

		cp = new ClusterPage(getDriver());
		cp.clickOnAddCluster()
		.enterHostIP(ClusterTestData.HOST_IP)
		.enterUserName(ClusterTestData.USER_NAME)
		.enterPassword(ClusterTestData.PASSWORD)
		.clickOnSubmit()
		.clickOnYes();
   
		String actual = cp.getAuthorizatonMessage();    
        Thread.sleep(1000);
        
		if (getBrowserLang().contains("eng")) {
			Assert.assertEquals(actual, "DataSource ".concat(ClusterTestData.HOST_IP).concat(ClusterTestData.EXPECTED_AUTHORIAZATION_MESSAGE));
		}
		if (getBrowserLang().contains("chinese")) {
			Assert.assertEquals(actual, "数据源 ".concat(ClusterTestData.HOST_IP).concat(ClusterTestData.SC_EXPECTED_AUTHORIAZATION_MESSAGE));
		}
		if (getBrowserLang().contains("japanese")) {
			Assert.assertEquals(actual, "データソース ".concat(ClusterTestData.HOST_IP).concat(ClusterTestData.JA_EXPECTED_AUTHORIAZATION_MESSAGE));
		}


	}



}
