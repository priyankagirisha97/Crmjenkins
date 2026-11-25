package com.comcast.myntra.exTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.myntra.generic.webdriverutility.JavaUtility;
import com.comcast.myntra.genericutility.ExcelUtility;
import com.comcast.myntra.genericutility.FileUtility;

public class MyntraEx {
	public static void main(String[] args) throws IOException, InterruptedException {
//    FileUtility fLib=new FileUtility();
//    ExcelUtility eLib=new ExcelUtility();
//    JavaUtility jLib=new JavaUtility();
//    
//    
//    
//   String BROWSER=fLib.getDataFromPropertiesFile("browser");
//	 String URL=fLib.getDataFromPropertiesFile("url");
//	
//	 WebDriver driver=null;
//	 if(BROWSER.equals("chrome")) {
//		 driver=new ChromeDriver();
//	 }else if(BROWSER.equals("firefox")) {
//		 driver=new FirefoxDriver();
//	 }else if(BROWSER.equals("edge")){
//	     driver=new EdgeDriver();
//	 }else{
//		 driver=new ChromeDriver();
//	 }
//	 
//	 driver.manage().window().maximize();
//     driver.get(URL);
//     
//     
//    
//     Actions act = new Actions(driver);
//
//     WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
//
//     act.moveToElement(men).perform();
//
//     Thread.sleep(2000);
//     
//     
//     
//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//
//     Actions act1 = new Actions(driver);
//     act1.moveToElement(men).perform();
//
//     WebElement tshirts = wait.until(
//         ExpectedConditions.elementToBeClickable(
//             By.xpath("//a[text()='T-Shirts']")
//         )
//     );
//
//     tshirts.click();
//     
//     List<WebElement> price= driver.findElements(By.xpath("//span[@class='product-discountedPrice' and translate(., 'Rs. ', '')>500 and translate(., 'Rs. ', '')<5000]"));
//     List<WebElement> productName= driver.findElements(By.xpath("//span[@class='product-discountedPrice' and translate(., 'Rs. ', '')>500 and translate(., 'Rs. ', '')<5000]/ancestor::div[@class='product-price']/preceding-sibling::h3"));
//     System.out.println("Price count: " + price.size());
//     System.out.println("Product Name count: " + productName.size());
//     for(int i=0;i<price.size();i++) {
//			WebElement pri = price.get(i);
//			WebElement prodname = productName.get(i);
//			eLib.setDataIntoExcel("writeData",eLib.getRowCount("writeData"), prodname.getText(),pri.getText());
//    
//     
//     
//     }
//	}
//}
		
		
        FileUtility fLib = new FileUtility();
        ExcelUtility eLib = new ExcelUtility();
        eLib.clearExcelData("writedata");
        JavaUtility jLib = new JavaUtility();

        String BROWSER = fLib.getDataFromPropertiesFile("browser");
        String URL = fLib.getDataFromPropertiesFile("url");

        WebDriver driver = null;

        if (BROWSER.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(URL);

        // Hover on Men
        Actions act = new Actions(driver);

        WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));

        act.moveToElement(men).perform();

        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Hover on Men again
        Actions act1 = new Actions(driver);
        act1.moveToElement(men).perform();

        // Click on T-Shirts
        WebElement tshirts = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='T-Shirts']")
            )
        );

        tshirts.click();

        // Find product prices
        List<WebElement> price = driver.findElements(By.xpath(
            "//span[@class='product-discountedPrice' and translate(., 'Rs. ', '')>500 and translate(., 'Rs. ', '')<5000]"
        ));

        // Find product names
        List<WebElement> productName = driver.findElements(By.xpath(
            "//span[@class='product-discountedPrice' and translate(., 'Rs. ', '')>500 and translate(., 'Rs. ', '')<5000]/ancestor::div[@class='product-price']/preceding-sibling::h3"
        ));

        System.out.println("Price count: " + price.size());
        System.out.println("Product Name count: " + productName.size());

        // Clear old Excel data
        eLib.clearExcelData("Products");

        // Start writing from row 1
        int rowNum = 1;

        // Write product names and prices into Excel
//        for (int i = 0; i < price.size() && i < productName.size(); i++) {
//
//            WebElement pri = price.get(i);
//            WebElement prodname = productName.get(i);
//
//            System.out.println(prodname.getText() + " : " + pri.getText());
//
//            eLib.setDataIntoExcel(
//                "Products",
//                rowNum++,
//                prodname.getText(),
//                pri.getText()
//            );
//        }
        
        
        for(int i = 0; i < productName.size(); i++)
        {
            WebElement prodname = productName.get(i);
            WebElement pri = price.get(i);

            eLib.setDataIntoExcel("writedata", i,
                    prodname.getText(), pri.getText());
        }

        System.out.println("Product details written successfully into Excel!");

        driver.quit();
    }
}


	
	


