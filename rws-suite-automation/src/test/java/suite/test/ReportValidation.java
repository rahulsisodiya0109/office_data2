package suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.constants.AppLang;
import suite.page.ClusterPage;
import suite.page.LoginPage;
import suite.page.ReportValidationPage;
import suite.testdata.ClusterTestData;
import suite.testdata.LoginTestData;
import suite.testdata.ReportTestData;
import suite.testdata.VolumeTestData;

public class ReportValidation extends TestBase {

	private ReportValidationPage rev;

	private String getVolumePageUrl() {
		return getEnv().concat(VolumeTestData.VOLUME_PAGE);
	}

	private String getStoragePageUrl() {
		return getEnv().concat(VolumeTestData.STORAGE_PAGE);
	}

	private void login() {
		new LoginPage(getDriver()).getLoginPage(getVolumePageUrl()).enterUserName(LoginTestData.USERNAME)
				.enterpassword(LoginTestData.PASSWORD).clickLoginBtn();

	}

	private void loginStorage() {
		new LoginPage(getDriver()).getLoginPage(getStoragePageUrl()).enterUserName(LoginTestData.USERNAME)
				.enterpassword(LoginTestData.PASSWORD).clickLoginBtn();

	}

	@Test(enabled =true, description = "Verify Report button is enabled in Volume Page", groups = { "wip",
			"ClusterTest" })

	public void reportEnableVolume() {
		login();

		rev = new ReportValidationPage(getDriver());

		boolean actual = rev.isReportEnabled();

		Assert.assertTrue(actual);
	}

	@Test(enabled = true, description = "Verify Report button is enabled in Storage vms Page", groups = { "wip",
			"ClusterTest" })

	public void reportEnableStorage() {
		loginStorage();

		rev = new ReportValidationPage(getDriver());

		boolean actual = rev.isReportEnabled();

		Assert.assertTrue(actual);
	}

	@Test(enabled = true, description = "Validate Download link is translated in CSV format", groups = { "wip",
			"ClusterTest" })

	public void reportDownloadCsv() {
		login();

		rev = new ReportValidationPage(getDriver());

		 rev.clickOnReportButton()
			.clickOnDownloadCsv();
		String str= rev.getReportCsv();
		
		if (getBrowserLang().contains(AppLang.ENG)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE);
		}
	
		else if (getBrowserLang().contains(AppLang.ZH)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE_CZ);
		}
		
		else if (getBrowserLang().contains(AppLang.JA)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE_JA);
		}
		

		
	}
	
	@Test(enabled =true, description = "Validate Download link is translated in PDF format", groups = { "wip",
	"ClusterTest" })

	public void reportDownloadPdf() throws InterruptedException {
		login();

		rev = new ReportValidationPage(getDriver());

		rev.clickOnReportButton()
		
		.clickOndownloadPdf();
		String str= rev.getReportPDF();
		
		if (getBrowserLang().contains(AppLang.ENG)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE);
		}
	
		else if (getBrowserLang().contains(AppLang.ZH)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE_CZ);
		}
		
		else if (getBrowserLang().contains(AppLang.JA)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE_JA);
		}
		Thread.sleep(2000);
	}
	
	@Test(enabled = true, description = "Validate Download link is translated in EXCEL format", groups = { "wip",
	"ClusterTest" })

	public void reportDownloadExcel() throws InterruptedException {
		login();

		rev = new ReportValidationPage(getDriver());

		rev.clickOnReportButton()
		
		.clickOndownloadExcel();
		String str= rev.getReportExcel();
		
		if (getBrowserLang().contains(AppLang.ENG)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE);
		}
	
		else if (getBrowserLang().contains(AppLang.ZH)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE_CZ);
		}
		
		else if (getBrowserLang().contains(AppLang.JA)) {
			Assert.assertEquals(str, ReportTestData.DOWNLOADMESSAGE_JA);
		}
		Thread.sleep(2000);
	}
	
	
	@Test(enabled =true, description = "validating upload excel file message", groups = { "wip",
	"ClusterTest" })

	public void reportUploadCsv() {
		login();

		rev = new ReportValidationPage(getDriver());

		rev.clickOnReportButton()
		
		.clickOnUploadCsv();
		String str= rev.getTextHeaderUploadExcel();
		
		if (getBrowserLang().contains(AppLang.ENG)) {
		Assert.assertEquals(str, ReportTestData.UPLOAD_EXCEL_MESSAGE);
		}
		
		else if (getBrowserLang().contains(AppLang.ZH)) {
			Assert.assertEquals(str, ReportTestData.UPLOAD_EXCEL_MESSAGE_CZ);
		}
		
		else if (getBrowserLang().contains(AppLang.JA)) {
			Assert.assertEquals(str, ReportTestData.UPLOAD_EXCEL_MESSAGE_JA);
		}
		
		
		
	}
	
}
