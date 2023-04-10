package ashot_api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImages {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://rsisodiya-trials77.orangehrmlive.com/auth/login");

		// since we have to compare so first need to read the stored image
		// and stored in bufferedimage class object
		BufferedImage expectedImage1 = ImageIO.read(new File("./capturedImages/OrangeHRMlogo.png")); //same
		BufferedImage expectedImage2 = ImageIO.read(new File("./capturedImages/OrangeHRMlogoCNG.png")); //not same

		// now capture the log image from webpage
		WebElement logoImageElement = driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div[1]/img"));
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
		BufferedImage actualImage = logoImageScreenshot.getImage(); // now capture image from screenshot
		
		// now to compare we have classes ImageDiffer & ImageDiff
		ImageDiffer imageDiff = new ImageDiffer();
		ImageDiff diff1 = imageDiff.makeDiff(expectedImage1, actualImage);

		if(diff1.hasDiff()==true) {
			System.out.println("Images are not same.");
		}else {
			
			System.out.println("Images are same.");
		}
		
		ImageDiff diff2 = imageDiff.makeDiff(expectedImage2, actualImage);
		if(diff2.hasDiff()==true) {
			System.out.println("Images are not same.");
		}else {
			
			System.out.println("Images are same.");
		}
		
		driver.quit();
	}
}
