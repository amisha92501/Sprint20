package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewProductPage {

	WebDriver driver;

	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "productname")
	private WebElement productNameTextField;

	@FindBy(name = "sales_start_date")
	private WebElement salesStartDate;

	@FindBy(name = "sales_end_date")
	private WebElement salesEndDate;

	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement vendorNameLookUpButton;

	@FindBy(name = "search_text")
	private WebElement vendorNameSearchBox;

	@FindBy(name = "search")
	private WebElement vendorNameSearchButton;

	@FindBy(id = "my_file_element")
	private WebElement productImageUploadButton;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSalesStartDate() {
		return salesStartDate;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}

	public WebElement getVendorNameLookUpButton() {
		return vendorNameLookUpButton;
	}

	public WebElement getVendorNameSearchBox() {
		return vendorNameSearchBox;
	}

	public WebElement getVendorNameSearchButton() {
		return vendorNameSearchButton;
	}

	public WebElement getProductImageUploadButton() {
		return productImageUploadButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void enterProductName() {
		productNameTextField.sendKeys("Addidas");
	}

	public void enterSalesStartDate() {

		salesStartDate.sendKeys("1999-03-18");
	}

	public void enterEndStartDate() {

		salesStartDate.sendKeys("1999-08-18");
	}
	
	public void clickOnVendorLookUpButton() {
		vendorNameLookUpButton.click();
	}

	
	public void selectVendorNameFromLookPage(String productPageTitle, String lookUpPageTitle, String vendorName) {
		
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, lookUpPageTitle);
		
		vendorNameSearchBox.sendKeys(vendorName);
		vendorNameSearchButton.click();
		driver.findElement(By.xpath("//a[text()='" + vendorName + "']")).click();
		wUtils.switchToWindow(driver, productPageTitle);
	}
	
	public void uploadProductImage(String path) {
		productImageUploadButton.sendKeys(path);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	

}
