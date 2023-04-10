package barcode_automation;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BarCodeAutomation {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://www.codereadr.com/demo/");

		// now will idetify the barCode xpath and get it's attribute for 'src' and store
		// it in a variable
//		String barCode = driver.findElement(By.xpath("//*[@id='infoTarget']/div[1]/img")).getAttribute("src");
		
		String barCode = driver.findElement(By.xpath("//*[@id=\"post-2677\"]/div/div/div/div[4]/div/div[1]/div/span/img")).getAttribute("src");
		

		//System.out.println(barCode);

		// convert into actual URL
		URL url = new URL(barCode);

		// read the url and store in object of BufferedImage class
		BufferedImage bufferedImage = ImageIO.read(url);

		// create an instance of LuminanceSource interface  
		// and object of BufferedImageLuminanceSource class
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);

		// create an object of BinaryBitmap class and HybridBinarizer and passing
		// luminanceSource as parameters
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

		// decode the binaryBitmap and store it in object of Result class
		Result result = new MultiFormatReader().decode(binaryBitmap);

		// get the text from stored result
		System.out.println(result.getText());
		
		
		driver.quit();
	}
}
