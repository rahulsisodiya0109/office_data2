package suite.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNgClass {
	
	WebDriver driver;
  
	@Test(enabled= true,priority=1, description="This test validates login functionality")
  public void login(){
	 
		System.out.println("Hello...");
	System.out.println("Netapp");
  }
	
	@Test(dependsOnMethods= "login",priority=1, description="This test validates login functionality")
	  public void homePage() {
			
			
		 
			System.out.println("Hello...");
			
	  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  driver.get("https://10.234.164.169/");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}


