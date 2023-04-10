package testArtifact;

import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIResults;

public class Cases_Test {

	@Test
	public void Case1() throws Exception {
		try {
			Case1.case1a();
			TestLinkIntegration.updateResults("test1", null, TestLinkAPIResults.TEST_FAILED);
		} catch (Exception e) {
			TestLinkIntegration.updateResults("test1", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}

	}

	

	@Test
	public void Case3() throws Exception {
		try {
			Case3.case3a();
			TestLinkIntegration.updateResults("test3", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkIntegration.updateResults("test3", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}
	}

	@Test
	public void Case4() throws Exception {
		try {
			Case4.case4a();
			TestLinkIntegration.updateResults("test4", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkIntegration.updateResults("test4", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
		}

	}

}
