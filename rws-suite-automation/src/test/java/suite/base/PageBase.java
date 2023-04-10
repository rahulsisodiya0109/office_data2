package suite.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import suite.constants.WebdriverConstants;
import suite.util.LinkUtil;

/**
 * Wrapper library around webdriver interface
 * 
 * @author arth.kumar
 *
 */
public class PageBase {
	private static Logger log = LoggerFactory.getLogger(PageBase.class);

	private WebDriverWait wait;
	private WebDriver driver;
	private Actions builder;
	private JavascriptExecutor js;
	private ExpectedCondition<Boolean> expectation;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT);
		this.builder = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * for handling alerts
	 */
	protected void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	/**
	 * for getting text from alert
	 * 
	 * @return alert text
	 */
	protected String getAlertTxt() {
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert().getText();
	}

	/**
	 * for clicking element by action class
	 * 
	 * @param element
	 */
	protected void clickingElementAction(WebElement element) {
		getWebElement(element);
		builder.moveToElement(element).click().build().perform();
	}

	/**
	 * Press enter button from keyboard
	 * 
	 * @param element
	 */
	public void pressEnterBtn(WebElement element) {
		getWebElement(element).sendKeys(Keys.ENTER);
	}

	/**
	 * Switch to iframe
	 * 
	 * @param element
	 */
	protected void switchToIframe(String id) {
		driver.switchTo().frame(id);
	}

	/**
	 * Get webelement
	 * 
	 * @param element
	 * @param inputText
	 */
	protected void selectDropDownWithValue(WebElement element, String inputText) {
		getWebElement(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(inputText);

	}

	/**
	 * switch back to page
	 */
	protected void switchToPage() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Clicking element using JS
	 * 
	 * @param element WebElement variable
	 */
	protected void clickingElementJS(WebElement element) {
		getWebElement(element);
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * scroll to given webelement
	 * 
	 * @param element WebElement variable
	 */
	protected void scrollTo(WebElement element) {
		getWebElement(element);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * get the element if the element is visible in the Webpage or not
	 * 
	 * @param element WebElement variable
	 */
	protected WebElement getWebElement(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			log.error("Please check the locator you've entered--> ", element.toString());
			log.error("Element not found please check the locator", e);
			Assert.fail();
		} catch (StaleElementReferenceException e) {
			return new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT)
					.until(ExpectedConditions.visibilityOf(element));
		}
		return element;
	}

	/**
	 * Verify if all the elements are visible in the the list
	 * 
	 * @param elements List of webElements
	 */
	protected List<WebElement> getWebElements(List<WebElement> elements) {
		try {
			return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (TimeoutException | NullPointerException e) {
			return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (StaleElementReferenceException e) {
			return new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT)
					.until(ExpectedConditions.visibilityOfAllElements(elements));
		}
	}

	/**
	 * Verify that element is visible if yes return true if no return false
	 */
	protected Boolean isElementInvisible(WebElement element) {

		return wait.until(ExpectedConditions.invisibilityOf(element));

	}

	/**
	 * Load the web url in the browser
	 * 
	 * @param pageURL url of the webpage
	 */
	protected void NavigatetoPage(String pageURL) {
		driver.navigate().to(pageURL);
	}

	/**
	 * Clicking on Webelement
	 * 
	 * @param element WebElement variable
	 */
	protected void clickingElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (ElementNotInteractableException e) {
			clickingElementJS(element);
		}
	}

	/**
	 * Enter value in the text box
	 * 
	 * @param textBoxLabel TextBox WebElement
	 * @param inputText    text that needs to be inserted
	 */
	protected void setText(WebElement textBoxLabel, String inputText) {
		clickingElement(textBoxLabel);
		getWebElement(textBoxLabel).clear();
		getWebElement(textBoxLabel).sendKeys(inputText);
	}

	/**
	 * Gets the textual value of WebElement
	 * 
	 * @param element WebElement variable
	 * @return the textual value of WebElement
	 */
	protected String getText(WebElement element) {
		return getWebElement(element).getText();
	}

	/**
	 * Get value of the attribute
	 * 
	 * @param element   WebElement variable
	 * @param attribute Attribute Value
	 * @return the value of the attribute
	 */
	protected String getAttributeValue(WebElement element, String attribute) {
		return getWebElement(element).getAttribute(attribute);
	}

	/**
	 * Hover over a the specified webelement
	 * 
	 * @param element WebElement variable
	 */
	protected void hoverOverElement(WebElement element) {
		getWebElement(element);
		builder.moveToElement(element).perform();
	}

	/**
	 * Returns false if element is disabled. Returns true if element is enabled.
	 * 
	 * @param element WebElement variable
	 */
	protected boolean isWebElementEnabled(WebElement element) {
		return getWebElement(element).isEnabled();
	}

	/**
	 * Returns false if element is selected. Returns true if element is Selected.
	 * 
	 * @param element WebElement variable
	 */
	protected boolean isWebElementSelected(WebElement element) {
		return getWebElement(element).isSelected();
	}

	/**
	 * Clear the text area of the Textbox.
	 * 
	 * @param textboxLabel TextBox WebElement
	 */
	protected void clearTextArea(WebElement textboxLabel) {
		getWebElement(textboxLabel).clear();
	}

	/**
	 * Returns the number of elements inside the list
	 * 
	 * @param elementList WebElement List
	 */
	protected Integer getListSizeOfElements(ArrayList<WebElement> elementList) {
		return getWebElements(elementList).size();
	}

	/**
	 * for checking broken link
	 * 
	 * @return return true if no broken link found , false if broken link present
	 */
	public Boolean areLinksBroken(List<WebElement> element) {
		getWebElements(element);
		Boolean flag = true;
		for (int i = 0; i < element.size(); i++) {
			if (LinkUtil.getResponseCode(getAttributeValue(element.get(i), "href")) != 200) { // href to src make new
																								// method
				log.error("Broken Links- " + getAttributeValue(element.get(i), "href"));
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * for checking broken Image
	 * 
	 * @return return true if no broken image found , false if broken link present
	 */
	public Boolean areImagesBroken(List<WebElement> element) {
		getWebElements(element);
		Boolean flag = true;
		for (int i = 0; i < element.size(); i++) {
			if (LinkUtil.getResponseCode(getAttributeValue(element.get(i), "src")) != 200) {
				log.error("Broken Links- " + getAttributeValue(element.get(i), "src"));
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * close the previous tab , switch to new tab
	 */
	protected void closePreviousTab() {
		Set<String> handlesSet = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handlesSet);
		driver.switchTo().window(handlesList.get(0));
		driver.close();
		driver.switchTo().window(handlesList.get(1));
	}

	/**
	 * wait for the current url to change into expected url
	 * 
	 * @param url
	 */
	protected void waitForUrl(String url) {
		expectation = arg0 -> driver.getCurrentUrl().equals(url);
		wait.until(expectation);
	}

	/**
	 * wait for all the elements of the page to load
	 */
	protected void waitForPageLoadComplete() {
		expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			wait.until(expectation);
		}
	}

	/**
	 * get the title of the current page
	 * 
	 * @return title of the current page
	 */
	protected String getPagetitle() {
		return driver.getTitle();
	}

	/**
	 * get the Current URL of the browser
	 * 
	 * @return current url
	 */
	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	protected void newWindow() {
		String parentHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			 try {
				    driver.switchTo().window(handle);
			
				  } catch (NoSuchWindowException e) {
				    System.out.println(e);
				  }
		    
		}
	}

}