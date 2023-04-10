package login;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import takeScreenshot.Screenshot;

public class Waitlist_Login {

	
	public static WebDriver driver;
	public static Screenshot ss;
	public static Properties pro;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public static void setEnv() throws Exception { 

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
		
		//extent report config
		report = new ExtentReports(System.getProperty("user.dir") + "/Extent-Reports/ExtentReportResults.html", true);
		report.addSystemInfo("Host Name", "LocalHost");
		report.addSystemInfo("Environment", "Test");
		report.addSystemInfo("UserName", "RS");
		report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		

	}
	
	public static void endReport(ITestResult result2) {
		if (result2.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result2.getThrowable());
		}

		report.endTest(test);
		report.flush();
	}

	public Object[][] dataSet() throws Exception {
		FileInputStream fis = new FileInputStream(pro.getProperty("excelPath"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int a = sheet.getPhysicalNumberOfRows();
		int b = sheet.getRow(0).getPhysicalNumberOfCells();

		Object arr[][] = new Object[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {

				Cell cell = sheet.getRow(i).getCell(j);
				switch (cell.getCellTypeEnum()) {
				case NUMERIC:

					arr[i][j] = Integer.toString((int) sheet.getRow(i).getCell(j).getNumericCellValue());
					break;
				case BOOLEAN:
					arr[i][j] = sheet.getRow(i).getCell(j).getBooleanCellValue();
					break;
				case STRING:
					String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
					if (cellValue.matches("-?\\d+")) {
						// If the cell value is a valid integer, convert it to an integer
						arr[i][j] = Integer.parseInt(cellValue);
					} else if (cellValue.matches("-?\\d+(\\.\\d+)?")) {
						// If the cell value is a valid floating-point number, convert it to a double
						arr[i][j] = Double.parseDouble(cellValue);
					} else {
						// Otherwise, store the cell value as a String
						arr[i][j] = cellValue;
					}
					break;
				default:
					arr[i][j] = null;
					break;

				}

			}
		}

		wb.close();
		return arr;

	}
		
	
	public static void enterURL() throws Exception {
		
		test = report.startTest("enterURL");
		
		Thread.sleep(5000);
		driver.get(pro.getProperty("url"));
		
		test.log(LogStatus.PASS, "Navigated to Stage URL");

	}

	public static void clickLogin() throws Exception {
		
		test = report.startTest("clickLogin");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Login']"))).click();
		
		test.log(LogStatus.PASS, "Login Clicked");

	}

	public static void enterCredentials(Object id, Object pass) throws Exception {
		
		test = report.startTest("enterCredentials");

		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();

		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys((String) id);
		driver.findElement(By.id("password")).sendKeys((String) pass);

		System.out.println((String) id + "  " + (String) pass);
		
		test.log(LogStatus.PASS, "Credentials Entered Successfully");

	}

	public static void submitLogin() throws Exception {
		
		test = report.startTest("submitLogin");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='sign_up_btn_s1 login_but']")).click();
		
		test.log(LogStatus.PASS, "Clicked Submit Login Button");
	}

	public static void returnLoginPage() throws Exception {
		
		test = report.startTest("returnLoginPage");
System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.get(pro.getProperty("loginPage"));

		test.log(LogStatus.PASS, "Retrun to Login Page");
	}
}
