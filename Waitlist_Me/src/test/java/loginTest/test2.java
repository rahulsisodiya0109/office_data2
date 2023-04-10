package loginTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testing.framework.EmailUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import takeScreenshot.Screenshot;

public class test2 {
	public WebDriver driver;
	public Screenshot ss;
	public Properties pro;
	public static ExtentTest test;
	public static ExtentReports report;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "/Extent-Reports/ExtentReportResults.html", true);
		report.addSystemInfo("Host Name", "LocalHost");
		report.addSystemInfo("Environment", "Test");
		report.addSystemInfo("UserName", "RS");
		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		

	}

	@BeforeTest
	public void setEnv() throws Exception {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		FileInputStream fis = new FileInputStream(
				"E:\\eclipse-workspace\\Waitlist_Me\\src\\test\\resources\\waitlist.properties");
		pro = new Properties();
		pro.load(fis);
		ss = new Screenshot(driver);
	}

	@Test
	public void dataSet1() throws Exception {
		
		test = report.startTest("dataSet1");

		System.out.println(pro.getProperty("url"));

		driver.get(pro.getProperty("url"));

		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}

	@Test
	public void dataSet2() throws Exception {

		test = report.startTest("dataSet2");


		Assert.assertEquals("test", "TEST");

		test.log(LogStatus.FAIL, "dataSet2 Pass");
	}

	@AfterMethod
	public void getResult(ITestResult result2) throws Exception {
		// ss.captureScreen(result2);
		// System.out.println(result2);

		if (result2.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result2.getThrowable());
		}

		report.endTest(test);
		report.flush();
		
		EmailUtils email = new EmailUtils();
		email.sendUsingGmail(pro, null, null);

	}

}
