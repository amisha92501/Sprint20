package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadsPage {

	public CreatingNewLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "salutationtype")
	private WebElement leadNameSalutatioknDropdown;

	@FindBy(name = "firstname")
	private WebElement leadFirstNameTextbox;

	@FindBy(name = "lastname")
	private WebElement leadLastnameTextbox;

	@FindBy(name = "company")
	private WebElement leadCompanyNameTextbox;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getLeadNameSalutatioknDropdown() {
		return leadNameSalutatioknDropdown;
	}

	public WebElement getLeadFirstNameTextbox() {
		return leadFirstNameTextbox;
	}

	public WebElement getLeadLastnameTextbox() {
		return leadLastnameTextbox;
	}

	public WebElement getLeadCompanyNameTextbox() {
		return leadCompanyNameTextbox;
	}
	
	

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void passSalutionToLeadNameDropDown(String option) {

		Select select = new Select(leadNameSalutatioknDropdown);
		select.selectByVisibleText(option);

	}

	public void enterFirstName(String firstName) {

		leadFirstNameTextbox.sendKeys(firstName);

	}

	public void enterLastName(String lastName) {

		leadLastnameTextbox.sendKeys(lastName);

	}

	public void enterCompanyName(String companyName) {

		leadCompanyNameTextbox.sendKeys(companyName);

	}
	
	public void passLeadIndustryInIndustryDropdown(String option) {
		
		Select select = new Select(industryDropdown);
		select.selectByVisibleText(option);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
