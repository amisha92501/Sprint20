package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {

	
WebDriver driver;
	
	public ProductInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String verifyProductInformation(String productName) {
		return driver.findElement(By.xpath("//span[contains(text(), '"+productName+"')]")).getText();
	}
}
