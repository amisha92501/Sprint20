package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	
	public VendorPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Vendor...\"]")
	private WebElement vendorPlusButton;

	public WebElement getVendorPlusButton() {
		return vendorPlusButton;
	}
	
	public void clickOnVendorPlusButton() {
		vendorPlusButton.click();
	}

}
