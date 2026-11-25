package com.comcast.myntra.exTest;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.Row;
public class SampleMyntra {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();

	    driver.get("https://www.myntra.com/");
	}
	}
	    
	    
//	 // Locate search box
//	    WebElement searchBox = driver.findElement(
//	        By.className("desktop-searchBar")
//	    );
//
//	    // Enter product name
//	    searchBox.sendKeys("Men T-shirts");
//
//	    // Press Enter
//	    searchBox.sendKeys(Keys.ENTER);
//
//	    // Search for products first
//
//	    List<WebElement> products = driver.findElements(
//	        By.cssSelector("h3.product-brand")
//	    );
//
//	    List<String> productNames = new ArrayList<>();
//
//	    for (WebElement product : products) {
//
//	        productNames.add(product.getText());
//	        
//	        System.out.println(productNames);
//
//	        driver.quit();
//	    }
//	}
//
//	    
//
//		    public static void writeData(List<String> productNames,
//		                                 List<Integer> prices) throws IOException {
//
//		        XSSFWorkbook wb = new XSSFWorkbook();
//
//		        XSSFSheet sheet = wb.createSheet("Products");
//
//		        Row header = sheet.createRow(0);
//
//		        header.createCell(0).setCellValue("Product Name");
//		        header.createCell(1).setCellValue("Price");
//
//		        int rowNum = 1;
//
//		        for (int i = 0; i < prices.size(); i++) {
//
//		            if (prices.get(i) > 500) {
//
//		                Row row = sheet.createRow(rowNum++);
//
//		                row.createCell(0).setCellValue(productNames.get(i));
//		                row.createCell(1).setCellValue(prices.get(i));
//		            }
//		        }
//
//		        FileOutputStream fos =
//		            new FileOutputStream("./TestttData/FilteredProducts.xlsx");
//
//		        wb.write(fos);
//
//		        fos.close();
//		        wb.close();
//
//		        System.out.println("Excel file created successfully!");
//		    }
//		}
//	
//		
//		
		
//		public static void writeData(List<String> productNames,
//                List<Integer> prices) throws IOException {
//
//XSSFWorkbook wb = new XSSFWorkbook();
//
//XSSFSheet sheet = wb.createSheet("Products");
//
//Row header = sheet.createRow(0);
//
//header.createCell(0).setCellValue("Product Name");
//header.createCell(1).setCellValue("Price");
//
//int rowNum = 1;
//
//for(int i = 0; i < prices.size(); i++) {
//
//if(prices.get(i) > 500) {
//
//Row row = sheet.createRow(rowNum++);
//
//row.createCell(0).setCellValue(productNames.get(i));
//row.createCell(1).setCellValue(prices.get(i));
//
//
//
//FileOutputStream fos =
//new FileOutputStream("./TestttData/FilteredProducts.xlsx");
//
//wb.write(fos);
//
//fos.close();
//wb.close();
//
//System.out.println("Excel file created successfully!");
//}
//}
//		}
//	}


	
		
		
//		// Create workbook
//        XSSFWorkbook wb = new XSSFWorkbook();
//
//        // Create sheet
//        XSSFSheet sheet = wb.createSheet("Products");
//
//        // Create header
//        Row header = sheet.createRow(0);
//
//        header.createCell(0).setCellValue("Product Name");
//        header.createCell(1).setCellValue("Price");
//
//        // Sample product data
//        String[] productNames = {
//            "Pepe Jeans",
//            "U.S. Polo Assn.",
//            "RARE RABBIT",
//            "Roadster"
//        };
//
//        int[] prices = {794, 781, 674, 450};
//
//        int rowNum = 1;
//
//        // Check price and write into Excel
//        for(int i = 0; i < prices.length; i++) {
//
//            if(prices[i] > 500) {
//
//                Row row = sheet.createRow(rowNum++);
//
//                row.createCell(0).setCellValue(productNames[i]);
//
//                row.createCell(1).setCellValue(prices[i]);
//            }
//        }
//
//        // Save Excel file
//        FileOutputStream fos =
//                new FileOutputStream("./TestttData/MyntraTestScript.xlsx");
//
//        wb.write(fos);
//
//        fos.close();
//        wb.close();
//
//        System.out.println("Excel file created successfully!");
//    }
//
//	}
		
		
//		 XSSFWorkbook wb = new XSSFWorkbook();
//
//	        XSSFSheet sheet = wb.createSheet("Products");
//
//	        // Create header row
//	        Row header = sheet.createRow(0);
//
//	        header.createCell(0).setCellValue("Product Name");
//	        header.createCell(1).setCellValue("Price");
//
//	        // Create first product row
//	        Row row1 = sheet.createRow(1);
//
//	        row1.createCell(0).setCellValue("Pepe Jeans T-Shirt");
//	        row1.createCell(1).setCellValue(794);
//
//	        // Create second product row
//	        Row row2 = sheet.createRow(2);
//
//	        row2.createCell(0).setCellValue("U.S. Polo Assn.");
//	        row2.createCell(1).setCellValue(781);
//
//	        FileOutputStream fos =
//	                new FileOutputStream("./sample/sample.xlsx");
//
//	        wb.write(fos);
//
//	        fos.close();
//	        wb.close();
//
//	        System.out.println("Excel file created successfully");
//	    }
	
//		XSSFWorkbook wb = new XSSFWorkbook();
//		wb.createSheet("Sample");
//		FileOutputStream fos=new FileOutputStream("./sample/sample.xlsx");
//		wb.write(fos);
//		fos.close();
//		wb.close();
	

