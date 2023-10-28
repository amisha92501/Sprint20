package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(linkText = "Leads")
	private WebElement leadsModule;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsModule;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsModule;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;
	
	@FindBy(linkText = "Products")
	private WebElement productsModule;
	
	@FindBy(linkText = "More")
	private WebElement moreModule;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsModule;
	
	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderModule;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement singOutOption;

	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getMoreModule() {
		return moreModule;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}

	public WebElement getSalesOrderModule() {
		return salesOrderModule;
	}

	public WebElement getAdministratorImage() {
		return administratorImage;
	}

	public WebElement getSingOutOption() {
		return singOutOption;
	}
	
	public void clickOnLeadModule() {
		leadsModule.click();
	}
	
	public void clickOnOrganizationModule() {
		organizationsModule.click();
	}
	
	public void clickOnContactsModule() {
		contactsModule.click();
	}
	
	public void clickOnOpportinitiesModule() {
		opportunitiesModule.click();
	}
	
	public void clickOnProductModule() {
		productsModule.click();
	}
	
	public void clickOnCampaignModule() {
		
		new Actions(driver).moveToElement(moreModule).perform();
		campaignsModule.click();
		
	}
	
	public void clickOnVendorModule() {
		new Actions(driver).moveToElement(moreModule).perform();
		vendorsModule.click();
	}
	
	public void clickOnSalesOrderModule() {
		new Actions(driver).moveToElement(moreModule).perform();
		salesOrderModule.click();
	}
	
	public void logoutAction() {
		new Actions(driver).moveToElement(administratorImage).perform();
		singOutOption.click();
	}
	

}
