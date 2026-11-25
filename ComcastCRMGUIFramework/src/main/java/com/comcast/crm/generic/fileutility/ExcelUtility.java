package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/data/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
		
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/data/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
           int rowCount=wb.getSheet(sheetName).getLastRowNum();
		   return rowCount;
		
		
	}
	public void setDataIntoExcel(String sheetname,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/data/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rowNum).createCell(cellNum);
		FileOutputStream fos=new FileOutputStream("./testdata/data/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}

}
