package product_Module;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CreatingNewProductPage;
import pomRepository.CreatingNewVendorPage;
import pomRepository.HomePage;
import pomRepository.ProductInformationPage;
import pomRepository.ProductPage;
import pomRepository.VendorInformationPage;
import pomRepository.VendorPage;
/**
 * 
 * @author Akash Deb
 *
 */
//@Listeners(genericUtility.ListenersImplementationClass.class)
public class ToCreateAProductTest extends BaseClass {
	
	@Test//(retryAnalyzer = genericUtility.RetryImpementationClass.class, priority = 2, groups = "regression")
	public void toCreateAProductWithVendorInformationTest() throws EncryptedDocumentException, IOException {
		//Test Data
		/*String vendorName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 1, 0);
		String productName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 1, 1);
		String salesStartDate = eUtils.fetchDateDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 1, 2);
		String salesEndDate = eUtils.fetchDateDataFromExcelSheet(IPathConstant.PRODUCT_SHEETNAME, 1, 3);
		*/
		
		
		//Object creation of all POM classes
		HomePage home = new HomePage(driver);
		VendorPage vendor = new VendorPage(driver);
		CreatingNewVendorPage createVendor = new CreatingNewVendorPage(driver);
		VendorInformationPage vendorInformation = new VendorInformationPage(driver);
		ProductPage product = new ProductPage(driver);
		CreatingNewProductPage createProduct = new CreatingNewProductPage(driver);
		ProductInformationPage productInformation = new ProductInformationPage(driver);
		
		//Creating vendor
		home.clickOnVendorModule();
		vendor.clickOnVendorPlusButton();
		createVendor.enterVendorName("Sohan");
		createVendor.clickOnSaveButton();
		String actualVendorName = vendorInformation.verifyVendorInformation("Sohan");
		
		//Verifying vendor
		Assert.assertTrue(actualVendorName.contains("Sohan"));
		System.out.println("Pass : the vendor is created");
		
		//Creating product
		home.clickOnProductModule();
		product.clickOnProductPlusButton();
		createProduct.enterProductName();
		createProduct.enterSalesStartDate();
		createProduct.enterEndStartDate();
		createProduct.clickOnVendorLookUpButton();
		createProduct.selectVendorNameFromLookPage("Products&action","Vendors&action", "Sohan");
		//createProduct.uploadProductImage(IPathConstant.PRODUCT_IMAGE_PATH);
		createProduct.clickOnSaveButton();
		/*String actualProductName = productInformation.verifyProductInformation("MRF");
		
		//Verifying product
		Assert.assertTrue(actualProductName.contains("MRF"));
		System.out.println("Pass: the product name is verified");
				System.out.println("Pass: the product name is verified");
		*/
		
	}

}
