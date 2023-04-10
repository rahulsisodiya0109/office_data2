package mailReport;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import com.testing.framework.EmailUtils;

public class EmailReport {

	@Test
	public static void sendEmail() throws Exception, IOException {
		EmailUtils email = new EmailUtils();
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\emailConfig1.properties"));
		List<String> attachments = new ArrayList<String>();
		attachments.add("E:\\eclipse-workspace\\Waitlist_Me\\Extent-Reports\\ExtentReportResults.html");
		email.sendUsingGmail(prop, "Test Execution Result Demo", "Hi Team, Execution is successful.", attachments);

	}
}
