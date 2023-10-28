package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Akash Deb
 *
 */
public class ExcelUtility {

	/**
	 * This method fetches String data from ExcelSheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String fetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_DATA_FILE_PATH);

		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();

	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public long fetchNumericDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_DATA_FILE_PATH);

		return (long)WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();

	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public boolean fetchBooleanDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_DATA_FILE_PATH);

		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();

	}
	
	public String fetchDateDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.EXCEL_DATA_FILE_PATH);

		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue().toString().substring(0, 10);

	}

}
