package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithSupportDate {
	public static void main(String[] args) throws IOException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
//		
//		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
//		Properties pObj=new Properties();
//		pObj.load(fis);
//		
		 String BROWSER=fLib.getDataFromPropertiesFile("browser");
		 String URL=fLib.getDataFromPropertiesFile("url");
		 String USERNAME=fLib.getDataFromPropertiesFile("username");
		 String PASSWORD=fLib.getDataFromPropertiesFile("password");
		 
		 String lastName=eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
		
////		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
////
////		Properties pObj=new Properties();
////		pObj.load(fis);
////		
//		String BROWSER=pObj.getProperty("browser");
//		String URL=pObj.getProperty("url");
//		String USERNAME=pObj.getProperty("username");
//		String PASSWORD=pObj.getProperty("password");
//		
//		Random random=new Random();
//		int randomInt=random.nextInt(1000);
//		
//		FileInputStream fis1=new FileInputStream("./testdata/data/TestScriptData.xlsx");
//		 Workbook wb=WorkbookFactory.create(fis1);
//		Sheet sh= wb.getSheet("contact");
//		Row row=sh.getRow(4);
//		String lastName=row.getCell(2).toString()+randomInt;
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver();
		 }else if(BROWSER.equals("edge")){
		     driver=new EdgeDriver();
		 }else{
			 driver=new ChromeDriver();
		 }
			 

			 //step1 login to app
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.get(URL);
			 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			 driver.findElement(By.id("submitButton")).click();
			 //navigate to org module
			 driver.findElement(By.linkText("Contacts")).click();
			 
			 //click on create org
			 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			 
			 String startDate=jLib.getSystemDateYYYYDDMM();
			 String endDate=jLib.getRequiredDateYYYYDDMM(30);
			 
			 //enter all the details and  create new org
			 driver.findElement(By.name("lastname")).sendKeys(lastName);
			 //start dtae
			 driver.findElement(By.name("support_start_date")).clear();
			 driver.findElement(By.name("support_start_date")).sendKeys(startDate);
			 
			 //end date
			 driver.findElement(By.name("support_end_date")).clear();
			 driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			 
			
			String actstartDate= driver.findElement(By.id("dtlview_Support Start Date")).getText();
			if(actstartDate.contains(startDate)) {
				System.out.println(startDate+"information is verified==PASS");
			}else {
				System.out.println(startDate+" information is  not verified==FAIL");
			}
			
			
			String actendDate= driver.findElement(By.id("dtlview_Support End Date")).getText();
			if(actendDate.contains(endDate)) {
				System.out.println(endDate+"information is verified==PASS");
			}else {
				System.out.println(endDate+" information is  not verified==FAIL");
			}
				
			 
			 driver.quit();
			 
			  
			  }

	}	

		
		
	


