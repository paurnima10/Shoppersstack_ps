package com.ShoppersStack.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utility {

	FileInputStream fis;
	
	public String readPropertyData(String key) throws IOException  {
		fis = new FileInputStream(FrameWorkConstants.propertyPath);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
	
	public String readExcelData(String SheetName,int rowNo, int cellNo ) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream(FrameWorkConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
}

