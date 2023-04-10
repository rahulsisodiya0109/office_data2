package suite.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.constants.App;
import suite.constants.AppLang;
import suite.page.LoginPage;
import suite.testdata.LoginTestData;

public class LoginTest extends TestBase {

	private LoginPage dp;
	WebDriver driver;

	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}

	@Test(enabled = false, description = "Verify successfully login with valid credentials", groups = { "wip",
			"LoginTest" })
	public void login()  {
		dp = new LoginPage(getDriver());

		dp.getLoginPage(getPageURL()).enterUserName(LoginTestData.USERNAME).enterpassword(LoginTestData.PASSWORD)
				.clickLoginBtn();

		String actual = dp.getSuccessMessage();

		if (getEnvLang().contains("netapp")) {

			if (getBrowserLang().contains("eng")) {
				Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE);
			}
			if (getBrowserLang().contains("chinese")) {
				Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE);
			}
			if (getBrowserLang().contains("japanese")) {
				Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE);
			}
		}

		else if (getEnvLang().contains("fujitsu")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE_Fuj);
		} else {

			Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE_Lenovo);
		}
		
		
	}

	@Test(enabled = false, description = "Verify the NetApp Logo with NetApp Image", groups = { "wip", "LoginTest" })
	public void login_TC_102() {
		dp = new LoginPage(getDriver());

		boolean actual = dp.getLoginPage(getPageURL()).getImageLogo();

		Assert.assertTrue(actual);

     
	}

	@Test( enabled=false,description = "Verify the NetApp Application Name", groups = { "wip", "LoginTest" })
	public void login_TC_103() {
		
		dp = new LoginPage(getDriver());
		

		String actual = dp.getLoginPage(getPageURL()).getNetAppApplicationName();

		if (getEnvLang().contains("netapp")) {

			Assert.assertEquals(actual, LoginTestData.EXPECTED_NETAPP_APPLICATION_NAME);

		} 
		else if (getEnvLang().contains("fujitsu")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_FUJITSU_APPLICATION_NAME);
		}
		else {

			Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE_Lenovo);
		}
		
	}

	@Test(enabled =  true, description = "Verify the NetApp supportlink ", groups = { "wip", "LoginTest" })
	public void login_TC_104() {
		dp = new LoginPage(getDriver());

		String actual = dp.getLoginPage(getPageURL()).clkOnSupportLink().getNetAppPageURL();
		
		if (getEnvLang().contains("netapp")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_NETAPPSUPPORT_LINK));
		}
		else if (getEnvLang().contains("fujitsu"))
		{
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_FUJITSUSUPPORT_LINK));
		}
		
		else if (getEnvLang().contains("lenovo"))
		{
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_LENOVOSUPPORT_LINK));
		}
		
	}

	@Test(enabled =true, description = "Verify the NetApp Homelink ", groups = { "wip", "LoginTest" })
	public void login_TC_105() {
		dp = new LoginPage(getDriver());

		String actual = dp.getLoginPage(getPageURL()).clkOnHomeLink().getNetAppHomeURL();
		
		if (getEnvLang().contains("netapp")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_NETAPPHOME_LINK));
		}
		
		else if (getEnvLang().contains("fujitsu")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_FUJITSUHOME_LINK));
		}
		
		else if (getEnvLang().contains("lenovo")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_LENOVOHOME_LINK));
		}

	}

	@Test(enabled =false,description = "Verify the ForgotPassword link ", groups = { "wip", "LoginTest" })
	public void login_TC_106() {
		dp = new LoginPage(getDriver());

		dp.getLoginPage(getPageURL()).clkOnForgotPasswordLink().enterRestetUserName(LoginTestData.RESTNAME)
				.clickOnSubmitBtn();

		String actual = dp.getInfoMessage();
		
		
		if (getBrowserLang().contains("eng")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_INFO_MESSAGE);
		}
		if (getBrowserLang().contains("chinese")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_INFO_MESSAGE_ZC);
		}
		if (getBrowserLang().contains("japanese")) {
			Assert.assertEquals(actual, LoginTestData.EXPECTED_INFO_MESSAGE_JP);
		}
	}
		

	@Test(enabled = false, description = "Verify the ForgotPassword link ", groups = { "wip", "LoginTest" })
	public void login_TC_107() {
		dp = new LoginPage(getDriver());

		dp.getLoginPage(getPageURL()).clkOnForgotPasswordLink().enterRestetUserName(LoginTestData.RESTNAME)
				.clickOnCancelBtn();

		String actual = dp.getNetAppApplicationName();
		
		if (getEnvLang().contains("netapp")) {

		Assert.assertEquals(actual, LoginTestData.EXPECTED_NETAPP_APPLICATION_NAME);
		}
		
		if (getEnvLang().contains("fujitsu")) {

			Assert.assertEquals(actual, LoginTestData.EXPECTED_FUJITSU_APPLICATION_NAME);
			}
		
		if (getEnvLang().contains("lenovo")) {

			Assert.assertEquals(actual, LoginTestData.EXPECTED_APPLICATION_NAME_LENOVO);
			}

	}

	@Test(enabled =false, description = "Verify the NetApp Logo with NetApp Image", groups = { "wip", "LoginTest" })
	public void login_TC_108() {
		dp = new LoginPage(getDriver());

		boolean actual = dp.getLoginPage(getPageURL()).clkOnForgotPasswordLink().getImageLogo();

		Assert.assertTrue(actual);

	}

	@Test(enabled =false,description = "Verify the NetApp supportlink ", groups = { "wip", "LoginTest" })
	public void login_TC_109() {
		dp = new LoginPage(getDriver());

		String actual = dp.getLoginPage(getPageURL()).clkOnForgotPasswordLink().clkOnSupportLink().getNetAppPageURL();

		if (getEnvLang().contains("netapp")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_NETAPPSUPPORT_LINK));
		}
		else if (getEnvLang().contains("fujitsu"))
		{
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_FUJITSUSUPPORT_LINK));
		}
		
		else if (getEnvLang().contains("lenovo"))
		{
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_LENOVOSUPPORT_LINK));
		}

	}

	@Test(enabled = false, description = "Verify the NetApp Homelink ", groups = { "wip", "LoginTest" })
	public void login_TC_110() {
		dp = new LoginPage(getDriver());

		String actual = dp.getLoginPage(getPageURL()).clkOnForgotPasswordLink().clkOnHomeLink().getNetAppHomeURL();

		if (getEnvLang().contains("netapp")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_NETAPPHOME_LINK));
		}
		
		else if (getEnvLang().contains("fujitsu")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_FUJITSUHOME_LINK));
		}
		
		else if (getEnvLang().contains("lenovo")) {
			Assert.assertTrue(actual.contains(LoginTestData.EXPECTED_LENOVOHOME_LINK));
		}

	}

	@Test(enabled = false, description = "Verify login with invalid credentials", groups = { "wip", "LoginTest" })
	public void login_invalid_creds() {
		dp = new LoginPage(getDriver());

		dp.getLoginPage(getPageURL()).enterUserName(LoginTestData.invalid_USERNAME)
				.enterpassword(LoginTestData.invalid_PASSWORD).clickLoginBtn();

		String actual = dp.getValidationMessage();

		if (getEnvLang().contains(App.NETAPP)) {

			if (getBrowserLang().contains(AppLang.ENG)) {
				Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_ErrorMessage);
			} else if (getBrowserLang().contains(AppLang.ZH)) {
				Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_ErrorMessage_CZ);
			} else if (getBrowserLang().contains(AppLang.JA)) {
				Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_ErrorMessage_JA);
			} else {

				Assert.fail();
			}

		}

	}
}


