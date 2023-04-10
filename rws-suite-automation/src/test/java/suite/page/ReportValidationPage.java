package suite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import suite.base.PageBase;

public class ReportValidationPage extends PageBase {
	
	private WebDriver driver;
	
	public ReportValidationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='nwf-mainbody']/ui-view/ui-view-ng-upgrade/ui-view/objects-grid/um-grid-template/nav/ul/div/li/report-action/div/button")
	private WebElement reportDisplay;
	
	@FindBy(xpath="//*[@id='nwf-mainbody']/ui-view/ui-view-ng-upgrade/ui-view/objects-grid/um-grid-template/nav/ul/div/li/report-action/div/div/button[1]")
	private WebElement downloadCSV;
	
	@FindBy(xpath="//*[@id='nwf-mainbody']/ui-view/ui-view-ng-upgrade/ui-view/objects-grid/um-grid-template/nav/ul/div/li/report-action/div/div/button[2]")
	private WebElement downloadPDF;
	
	@FindBy(xpath="//*[@id='nwf-mainbody']/ui-view/ui-view-ng-upgrade/ui-view/objects-grid/um-grid-template/nav/ul/div/li/report-action/div/div/div/button[1]")
	private WebElement downloadExcel;
	
	@FindBy(xpath="//button[@class='dropdown-toggle btn btn-flat btn-sm']")
	private WebElement reportButton;
	
	@FindBy(css="excel-report-config > button")
	private WebElement uploadExcel;
	
	@FindBy(css="body > ngb-modal-window > div > div > div.modal-header> h4")
	private WebElement getTextHeader;
	
	@FindBy(css="nwf-alert > ngb-alert > div > div.flex-grow-1.ml-2.mr-4 > div")
	private WebElement getDownlaodMessage;
	
	@FindBy(css="nwf-alert > ngb-alert > div > div.flex-grow-1.ml-2.mr-4 > div")
	private WebElement getDownlaodPDFMessage;
	
	@FindBy(css="nwf-alert > ngb-alert > div > div.flex-grow-1.ml-2.mr-4 > div")
	private WebElement getDownlaodExcelMessage;
	
	public Boolean isReportEnabled() {

		return isWebElementEnabled(reportDisplay);

	}

	public String getReportCsv() {

		return getText(getDownlaodMessage);
	}

	public ReportValidationPage clickOnReportButton() {

		clickingElement(reportButton);
		return this;
	}

	public void clickOnDownloadCsv() {
		clickingElement(downloadCSV);
		
	}

	public ReportValidationPage clickOnUploadCsv() {

		clickingElementJS(uploadExcel);
		return this;

	}
	
	public String getTextReportExcelValue() {

		return getText(uploadExcel);
	}

	public String getTextHeaderUploadExcel() {
		return getText(getTextHeader);
	}

	public void clickOndownloadPdf() {
		clickingElement(downloadPDF);
	}

	public String getReportPDF() {
        return getText(getDownlaodExcelMessage);
	}

	
	public void clickOndownloadExcel() {
		clickingElement(downloadExcel);
	}

	public String getReportExcel() {
		return getText(getDownlaodExcelMessage);
		
		
	}

}
