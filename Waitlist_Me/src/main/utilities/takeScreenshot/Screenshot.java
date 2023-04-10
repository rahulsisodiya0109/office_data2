package takeScreenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Screenshot {

	public WebDriver driver;

	public Screenshot(WebDriver driver2) {
		this.driver=driver2;
	}

	public void captureScreen(ITestResult result) throws Exception {

		// if (result.getStatus() == ITestResult.SUCCESS) {}

		System.out.println("test success");

		// create reference of takescreenshot interface and typecasting
		TakesScreenshot ts = (TakesScreenshot) driver;

		// use screenshot as method to capture screenshot in file format
		// get screenshotas method return file type - FILE
		File source = ts.getScreenshotAs(OutputType.FILE);

		// copyfile to specific location
		FileUtils.copyFile(source, new File("./screenshot/" + result.getName() + ".png"));
		System.out.println(result.getName() + " method screenshot");

	}
}
