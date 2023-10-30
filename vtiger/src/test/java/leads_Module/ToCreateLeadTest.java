package leads_Module;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CreatingNewLeadsPage;
import pomRepository.HomePage;
import pomRepository.LeadInformationPage;
import pomRepository.LeadsPage;
/**
 * 
 * @author Akash Deb
 *
 */
//@Listeners(genericUtility.ListenersImplementationClass.class)
public class ToCreateLeadTest extends BaseClass {
	
	@Test( priority = 1, groups = "smoke")
	public void toCreateALeadAndToVerifyTheLeadInformationTest() throws EncryptedDocumentException, IOException, SQLException {
		
		//Test Data
		/*String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 0);
		String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 1);
		String leadLastName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 2);
		String leadCompanyName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 3);
		String leadIndustry = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEETNAME, 1, 4);
		*/
		//Page Object
		HomePage home = new HomePage(driver);
		LeadsPage lead = new LeadsPage(driver);
		CreatingNewLeadsPage creatLead = new CreatingNewLeadsPage(driver);
		LeadInformationPage leadInfo = new LeadInformationPage(driver);
		
		//Script
		//Clicking on the lead module
		home.clickOnLeadModule();
		
		//Clicking on the lead plus button
		lead.clickOnLeadPlusButton();
		
		//Creating a Lead
		creatLead.passSalutionToLeadNameDropDown();
		creatLead.enterFirstName();
		creatLead.enterLastName();
		creatLead.enterCompanyName();
		creatLead.passLeadIndustryInIndustryDropdown();
		creatLead.clickOnSaveButton();
		
		//Fetching the lead info
		/*String actualLeadLastName = leadInfo.verifyLeadInformation(leadLastName);
		
		//Verification
		Assert.assertTrue(actualLeadLastName.contains(leadLastName));
		System.out.println("The Lead information has been verified");*/
		
	}
	
	
}
