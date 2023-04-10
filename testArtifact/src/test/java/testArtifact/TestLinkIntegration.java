package testArtifact;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {

	public static final String TESTLINK_KEY = "acebe5f56e85316c30291aafd38bfe42";
	public static final String TESTLINK_URL = "https://testlink.systangostudios.com/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "QA-Systango";
	public static final String TEST_PLAN_NAME = "rs_Plan1";
	public static final String TEST_CASE_NAME = "";
	public static final String TEST_BUILD_NAME = "rsTest_v1.0";
	
	public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException {
		
		TestLinkAPIClient testlink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, TEST_BUILD_NAME, exception, results);
	}
}
