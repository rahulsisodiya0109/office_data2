package com.waitlist.utilities;

/*
 * 
This is the Listener class used to generate the extent report
*
*
*/

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext itestContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
		String repName = "Test-Report" + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output-extReport/" + repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "rahul");

		htmlReporter.config().setDocumentTitle("WAITLIST Project");
		htmlReporter.config().setReportName("");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult testResult) {

		logger = extent.createTest(testResult.getName()); // create a new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN)); // send the pass
																									// information

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testResult.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				logger.pass("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestFailure(ITestResult testResult) {

		logger = extent.createTest(testResult.getName()); // create a new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED)); // send the fail
																									// information

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testResult.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkip(ITestResult testResult) {

		logger = extent.createTest(testResult.getName()); // create a new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName(), ExtentColor.ORANGE)); // send the skip
																										// information

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testResult.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				logger.skip("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void onFinish(ITestContext itestContext) {
		extent.flush();
	}

}
