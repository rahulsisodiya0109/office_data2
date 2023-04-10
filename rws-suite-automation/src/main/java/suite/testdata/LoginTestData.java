package suite.testdata;

public class LoginTestData {

	public static final String USERNAME = "umadmin";    //admin
	public static final String PASSWORD = "admin";      //netapp1!
	public static final String invalid_USERNAME = "umadmin";
	public static final String invalid_PASSWORD = "netapp1!";
	public static final String EXPECTED_VALIDATION_MESSAGE = "Active IQ Unified Manager";
	public static final String EXPECTED_VALIDATION_MESSAGE_Fuj = "ActiveIQ Unified Manager";
	public static final String EXPECTED_VALIDATION_MESSAGE_Lenovo = "DM Series Unified Manager";
	public static final String EXPECTED_VALIDATION_ErrorMessage = "Sign In Failed. Please verify Username and Password.";
	public static final String EXPECTED_VALIDATION_ErrorMessage_CZ = "登录失败。请验证用户名和密码。";
	public static final String EXPECTED_VALIDATION_ErrorMessage_JA = "サインインに失敗しました。ユーザ名とパスワードを確認してください。";
	public static final CharSequence EXPECTED_NETAPPSUPPORT_LINK = "data-infrastructure-management";
	public static final CharSequence EXPECTED_NETAPPHOME_LINK = "http://netapp.com/";
	public static final String EXPECTED_NETAPP_APPLICATION_NAME = "Active IQ Unified Manager";
	public static final String RESTNAME = "test";
	public static final String EXPECTED_INFO_MESSAGE = "An email with steps to reset your password has been sent, provided that test is a valid username with an email address associated with it.";
	public static final String EXPECTED_INFO_MESSAGE_ZC = "如果 test 是有效的用户名，并具有关联的电子邮件地址，系统将向您发送一封电子邮件，并在其中说明重置密码的步骤。";
	public static final String EXPECTED_INFO_MESSAGE_JP = "ユーザ名 test に関連付けられた E メール アドレスに、パスワードのリセット手順を記載した E メールを送信しました。";
	public static final String EXPECTED_FUJITSU_APPLICATION_NAME = "FUJITSU Storage ETERNUS Software Active IQ Unified Manager";
	public static final Object EXPECTED_APPLICATION_NAME = "Active IQ Unified Manager";
	public static final String EXPECTED_APPLICATION_NAME_FUJITSU = "ActiveIQ Unified Manager";
	public static final String EXPECTED_APPLICATION_NAME_LENOVO = "DM Series Unified Manager";
	
	public static final String EXPECTED_HELP_DOCUMENTATION_URL = "https://10.234.172.65/um/en/WW_Help_5.0/GUID-F6B0CAA6-72F1-4846-BE45-EA66AD3DF39A/wwhelp/wwhimpl/js/html/wwhelp.htm#context=GUID-F6B0CAA6-72F1-4846-BE45-EA66AD3DF39A&topic=GUID-241557D7-C5BD-4D60-B214-781271CCF86D";
	public static final CharSequence EXPECTED_FUJITSUSUPPORT_LINK = "www.fujitsu.com";
	public static final CharSequence EXPECTED_LENOVOSUPPORT_LINK = "datacentersupport.lenovo.com";
	public static final CharSequence EXPECTED_FUJITSUHOME_LINK = "https://www.fujitsu.com/";
	public static final CharSequence EXPECTED_LENOVOHOME_LINK = "https://www.lenovo.com/";

}

