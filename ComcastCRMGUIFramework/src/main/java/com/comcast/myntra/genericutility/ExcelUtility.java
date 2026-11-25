package com.comcast.myntra.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
//	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
//		FileInputStream fis=new FileInputStream("./TestttData/MyntraTestScript.xlsx");
//		Workbook wb=WorkbookFactory.create(fis);
//		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
//		return data;
//		
//	}
//	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
//		FileInputStream fis=new FileInputStream("./TestttData/MyntraTestScript.xlsx");
//		Workbook wb=WorkbookFactory.create(fis);
//           int rowCount=wb.getSheet(sheetName).getLastRowNum();
//		   return rowCount;
//	}
//		
//		
//
//		
//		
//	
//	public void setDataIntoExcel(String sheetName, int rowNum, String productName, String price) throws EncryptedDocumentException, IOException {
//		 FileInputStream fis = new FileInputStream("./TestttData/MyntraTestScript.xlsx");
//	        Workbook wb = WorkbookFactory.create(fis);
//
//	        Row row = wb.getSheet(sheetName).createRow(rowNum+1);
//
//	        row.createCell(0).setCellValue(productName);
//	        row.createCell(1).setCellValue(price);
//
//	        FileOutputStream fos = new FileOutputStream("./TestttData/MyntraTestScript.xlsx");
//	        wb.write(fos);
//
//	        wb.close();
//	        
//   
//	        
//	        
//	        public void clearExcelData(String sheetName) throws IOException {
//
//	            FileInputStream fis = new FileInputStream("./TestttData/MyntraTestScript.xlsx");
//	            Workbook wb = WorkbookFactory.create(fis);
//
//	            Row row;
//
//	            for (int i = 1; i <= wb.getSheet(sheetName).getLastRowNum(); i++) {
//	                row = wb.getSheet(sheetName).getRow(i);
//
//	                if (row != null) {
//	                    wb.getSheet(sheetName).removeRow(row);
//	                }
//	            }
//
//	            fis.close();
//
//	            FileOutputStream fos = new FileOutputStream("./TestttData/MyntraTestScript.xlsx");
//	            wb.write(fos);
//
//	            fos.close();
//	            wb.close();
//	        }
//	    }
//		
//		
//		
//	}
	
	
	
	
	
	
	 public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
	            throws EncryptedDocumentException, IOException {

	        FileInputStream fis = new FileInputStream("./TestttData/MyntraTestScript.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);

	        String data = wb.getSheet(sheetName).getRow(rowNum)
	                .getCell(cellNum).getStringCellValue();

	        wb.close();
	        fis.close();

	        return data;
	    }

	    // To get row count
	    public int getRowCount(String sheetName)
	            throws EncryptedDocumentException, IOException {

	        FileInputStream fis = new FileInputStream("./TestttData/MyntraTestScript.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);

	        int rowCount = wb.getSheet(sheetName).getLastRowNum();

	        wb.close();
	        fis.close();

	        return rowCount;
	    }

	    // To write product name and price into Excel
	    public void setDataIntoExcel(String sheetName, int rowNum,
	            String productName, String price)
	            throws EncryptedDocumentException, IOException {

	        FileInputStream fis = new FileInputStream("./TestttData/MyntraTestScript.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);

	        Row row = wb.getSheet(sheetName).getRow(rowNum);

	        if (row == null) {
	            row = wb.getSheet(sheetName).createRow(rowNum);
	        }

	        row.createCell(0).setCellValue(productName);
	        row.createCell(1).setCellValue(price);

	        fis.close();

	        FileOutputStream fos = new FileOutputStream("./TestttData/MyntraTestScript.xlsx");
	        wb.write(fos);

	        fos.close();
	        wb.close();
	    }

	    // To clear old product data while keeping headers
	    public void clearExcelData(String sheetName) throws IOException {

//	        FileInputStream fis = new FileInputStream("./TestttData/MyntraTestScript.xlsx");
//	        Workbook wb = WorkbookFactory.create(fis);
//
//	        Row row;
//
//	        for (int i = 1; i <= wb.getSheet(sheetName).getLastRowNum(); i++) {
//
//	            row = wb.getSheet(sheetName).getRow(i);
//
//	            if (row != null) {
//	                wb.getSheet(sheetName).removeRow(row);
//	            }
//	        }
//
//	        fis.close();
//
//	        FileOutputStream fos = new FileOutputStream("./TestttData/MyntraTestScript.xlsx");
//	        wb.write(fos);
//
//	        fos.close();
//	        wb.close();
	    	FileInputStream fis = new FileInputStream("./TestttData/MyntraTestScript.xlsx");

	        Workbook wb = WorkbookFactory.create(fis);

	        for (int i = wb.getSheet(sheetName).getLastRowNum(); i >= 0; i--) {

	            Row row = wb.getSheet(sheetName).getRow(i);

	            if (row != null) {
	                wb.getSheet(sheetName).removeRow(row);
	            }
	        }

	        fis.close();

	        FileOutputStream fos = new FileOutputStream("./TestttData/MyntraTestScript.xlsx");

	        wb.write(fos);

	        fos.close();
	        wb.close();
	    }


	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	




