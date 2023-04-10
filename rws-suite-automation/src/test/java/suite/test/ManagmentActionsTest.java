package suite.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.DashBoardPage;
import suite.page.LoginPage;
import suite.page.ManagementActionsPage;
import suite.testdata.ClusterTestData;
import suite.testdata.LoginTestData;

public class ManagmentActionsTest extends TestBase {

	private ManagementActionsPage map;

	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}


	private void getLoginPage() {


		LoginPage log = new LoginPage(getDriver());

		log
		.enterUserName(LoginTestData.USERNAME)
		.enterpassword(LoginTestData.PASSWORD)
		.clickLoginBtn();
	}

		@Test(enabled=true,priority = 0, description = "Validagte The Fix_ALL is Enable or Not" , groups = { "wip", "ManagmentAction Test" })
		public void isFixAllIsEnabledOrNot() {
			
			map = new ManagementActionsPage(getDriver());
			map.getLoginPage(getPageURL());
			getLoginPage();
			
	
			map.fixAllIsEnableOrNot();
			//throw new SkipException("Skipping this exception:The FIX_ALL Button is Enabled,so we can proced Further Actions");
			
			
		
	
		}
		
		@Test(enabled=true, description = "Validagte The Dismiss_All Is Enabled or Not" , groups = { "wip", "ManagmentAction Test" })
		public void isDismissAllEnableOrNot() throws InterruptedException {
			
			map = new ManagementActionsPage(getDriver());
			map.getLoginPage(getPageURL());
			getLoginPage();
			
			map.clickOnDropdown();
			Thread.sleep(1000);
			map.isDismisssAllEnabled();
			//throw new SkipException("Skipping this exception: The Dismiss_All Has Enabled");
				
	
		}

}
