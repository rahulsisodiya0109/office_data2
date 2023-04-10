package suite.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.AboutScreen;
import suite.page.LoginPage;
import suite.testdata.LoginTestData;

public class AboutTest extends TestBase {

	private AboutScreen as;
	private XSSFSheet eu;

	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}

	private void login() {
		new LoginPage(getDriver()).getLoginPage(getPageURL()).enterUserName(LoginTestData.USERNAME)
				.enterpassword(LoginTestData.PASSWORD).clickLoginBtn();

	}

	private XSSFSheet getSheet() {
		return getTestData().getSheet("About");
	}

	@Test(enabled =false, description = "Verify about screen", groups = { "wip", "LoginTest" })
	public void TC_112() {

		login();
		as = new AboutScreen(getDriver());

		String actual = as.clickOnHelpLink().clickOnAboutLink().getTitle();

		if (getEnvLang().contains("netapp")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_APPLICATION_NAME);

		} else if (getEnvLang().contains("fujitsu")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_APPLICATION_NAME_FUJITSU);
		}

		else {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_APPLICATION_NAME_LENOVO);
		}

	}

	@Test(enabled = true, description = "Verify build path in about screen", groups = { "wip", "LoginTest" })
	public void TC_113() {

		login();
		as = new AboutScreen(getDriver());

		String actual = as.clickOnHelpLink().clickOnAboutLink().getBuildVersionNumber();

		CharSequence teststring = actual.substring(12);

		Assert.assertTrue(as.getPageURL("C:\\Users\\supriyak\\Downloads").verifyBuildVersion(teststring));

	}

	@Test(enabled =false, description = "Verify copyright details in about screen", groups = { "wip", "LoginTest" })
	public void TC_114() {

		login();
		as = new AboutScreen(getDriver());

		String actual = as.clickOnHelpLink().clickOnAboutLink().getCopyrightDetails();

		if (getEnvLang().contains("netapp") && getBrowserLang().contains("eng")) {

			Assert.assertEquals(actual, getSheet().getRow(1).getCell(1).getStringCellValue());

		} else if (getEnvLang().contains("netapp") && getBrowserLang().contains("chinese")) {
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(2).getStringCellValue());

		}

		else if (getEnvLang().contains("netapp") && getBrowserLang().contains("japanese")) {
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(3).getStringCellValue());

		}

		 if (getEnvLang().contains("fujitsu") && getBrowserLang().contains("eng")) {

			Assert.assertEquals(actual, getSheet().getRow(1).getCell(4).getStringCellValue());

		} else if (getEnvLang().contains("fujitsu") && getBrowserLang().contains("japanese")) {
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(5).getStringCellValue());

		}

		 if (getEnvLang().contains("lenovo") && getBrowserLang().contains("eng")) {

			Assert.assertEquals(actual, getSheet().getRow(1).getCell(6).getStringCellValue());

		} else if (getEnvLang().contains("lenovo") && getBrowserLang().contains("chinese")) {
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(7).getStringCellValue());

		}

		else if (getEnvLang().contains("lenovo") && getBrowserLang().contains("japanese")) {
			Assert.assertEquals(actual, getSheet().getRow(1).getCell(8).getStringCellValue());

		}

	}

	@Test(enabled =false, description = "Verify logo of Application", groups = { "wip", "LoginTest" })
	public void TC_115() {

		login();
		as = new AboutScreen(getDriver());

		if (getEnvLang().contains("netapp")) {
			Boolean actual = as.clickOnHelpLink().clickOnAboutLink().getNetAppLogo();
			Assert.assertTrue(actual);
		}
		
		else
		{
			Boolean actual = as.clickOnHelpLink().clickOnAboutLink().getOEMLogo();
			Assert.assertTrue(actual);
			
		}
		
		

	}
}
