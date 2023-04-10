package loginTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import login.Waitlist_Login;

public class Test1 extends Waitlist_Login {

	@BeforeClass
	public void set_Env() throws Exception {
		setEnv();
	}

	@DataProvider
	public Object[][] data_Set() throws Exception {
		return dataSet();
	}

	@Test(priority = 1)
	public void enter_URL() throws Exception {
		enterURL();
	}

	@Test(priority = 2)
	public void click_Login() throws Exception {
		clickLogin();
	}

	@Test(priority = 3, dataProvider = "data_Set")
	public void enter_Credentials(Object user, Object pass) throws Exception {
		enterCredentials(user, pass);
	}

	@Test(priority = 4)
	public void submit_Login() throws Exception {
		submitLogin();
	}

	@Test(priority = 5)
	public void return_LoginPage() throws Exception {
		returnLoginPage();
	}

	@AfterMethod
	public void capture(ITestResult result) throws Exception {
		ss.captureScreen(result);
		Waitlist_Login.endReport(result);
		// System.out.println(result);
	}
}
