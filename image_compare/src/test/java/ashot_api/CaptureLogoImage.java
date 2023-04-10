package ashot_api;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogoImage {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://rsisodiya-trials77.orangehrmlive.com/auth/login");

		// capture the logo xpath and store in webelement object
		WebElement logoImageElement = driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div[1]/img"));

		// capture screenshot with an object of AShot() class and shore in screenshot
		// class object
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);

		// now extract image from the screenshot
		ImageIO.write(logoImageScreenshot.getImage(), "png", new File("./capturedImages/OrangeHRMlogo.png"));

		File f = new File("./capturedImages/OrangeHRMlogo.png");
		if (f.exists()) {
			System.out.println("logo captured");
		} else {
			System.out.println("Not captured");
		}
	}
}
