package signup;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waitlist_Signup {

	public static WebDriver driver;
	public static Properties pro;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// open the sign-up page
		driver.get("https://fourtopstaging.appspot.com/");

		// click at sign-up button
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();

		// clear the field and inserted values to search with
		driver.findElement(By.xpath("//input[@id ='searchzip']")).clear();
		driver.findElement(By.xpath("//input[@id ='searchzip']")).sendKeys("10001");
		driver.findElement(By.xpath("//input[@placeholder = 'Business name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder = 'Business name']")).sendKeys("restaurant");

		// created an object of Select class to select from dropdown
		Select country = new Select(driver.findElement(By.xpath("//select[@id='plan_id_search']")));
		country.selectByVisibleText("USA");

		// click search button
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchbutton"))).click();

		// click first search object
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@id='list_of_places_id_div']/div[2]/div[1]/ul[1]"))).click();

		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// click Save my Business
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save my Business']"))).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='user_form_name']")).sendKeys("Namrata");
		driver.findElement(By.xpath("//input[@id='user_form_last_name']")).sendKeys("Shah");
		driver.findElement(By.xpath("//input[@id='user_form_email']")).sendKeys("namratashah_124@yopmail.com");
		driver.findElement(By.xpath("//input[@id='user_form_password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='user_form_password_confirmation']")).sendKeys("123456");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='signup_button']"))).click();

	}
}
