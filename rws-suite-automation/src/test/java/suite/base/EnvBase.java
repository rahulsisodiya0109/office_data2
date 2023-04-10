package suite.base;

import suite.testdata.AppData;

/**
 * This Class contains environment variables for setting and getting environment
 * variables for automation framework
 * 
 * @author arth
 *
 */
public class EnvBase {

	private String env;

	/**
	 * get environment variable
	 * 
	 * @return baseurl of environment
	 */
	public String getEnv() {
		return env;
	}

	/**
	 * set environment variables
	 * 
	 * @param env
	 */
	public void setEnv(String env) {
		switch (env) {
		case "netapp":
			this.env = AppData.NETAPP;
			break;

		case "fujitsu":
			this.env = AppData.FUJITSU;
			break;

		case "lenovo":
			this.env = AppData.LENOVO;
			break;

		default:
			this.env = AppData.NETAPP;
			break;
		}
	}
}
