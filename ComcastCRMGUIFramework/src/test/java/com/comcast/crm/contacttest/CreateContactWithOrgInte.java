package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgInte {
	public static void main(String[] args) throws IOException {
		
		//precondition also should be automated and the condition is, atleast one organization should be created
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
//		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
//
//		Properties pObj=new Properties();
//		pObj.load(fis);
		
		 String BROWSER=fLib.getDataFromPropertiesFile("browser");
		 String URL=fLib.getDataFromPropertiesFile("url");
		 String USERNAME=fLib.getDataFromPropertiesFile("username");
		 String PASSWORD=fLib.getDataFromPropertiesFile("password");
		 
		 
		 String orgName=eLib.getDataFromExcel("contact", 7, 2)+ jLib.getRandomNumber();
		 String contactLastName=eLib.getDataFromExcel("contact", 7, 3);
		 
//		 //generate the random number
//		 Random random=new Random();
//		 int randomInt=random.nextInt(10000);
//		 //wb.close();
//		 
//		 
//		 //read testscript data from excel file
//		 FileInputStream fis1=new FileInputStream("./testdata/TestScriptData.xlsx");
//		 Workbook wb=WorkbookFactory.create(fis1);
//		 Sheet sh=wb.getSheet("contact");
//		 Row row=sh.getRow(7);
//		 String orgName=row.getCell(2).toString()+randomInt;
//		 String contactLastName=row.getCell(3).toString();
//		  wb.close();
		 
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
	

		
		 wLib.waitForPageToLoad(driver);
		 driver.get(URL);
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 //driver.findElement(By.id("phone")).sendKeys("phoneNumber");
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName)) {
				System.out.println(orgName+"  is verified==PASS");
			}else {
				System.out.println(orgName +"  is  not verified==FAIL");
			}
		
		 
		 //step5 navigate to contact module
			driver.findElement(By.linkText("Contacts")).click();
			 
			 //click on create org
			 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			 //enter all the details and  create new org
			 driver.findElement(By.name("lastname")).sendKeys(contactLastName);
			 driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			 
			 //switch to child window
			 wLib.switchNewBrowserTabBasedOnURL(driver, "module=Accounts");
			 
//			 Set<String>set=driver.getWindowHandles();
//			Iterator<String> it= set.iterator();
//			while(it.hasNext()) {
//				String windowID=it.next();
//				driver.switchTo().window(windowID);
//				String actUrl=driver.getCurrentUrl();
//				if(actUrl.contains("module=Accounts")){
//					break;
//				}
//				
//			}
//			
			
			 driver.findElement(By.name("search_text")).sendKeys(orgName);
			 driver.findElement(By.name("search")).click();
			 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			 
			 //switch to parent window
			 wLib.switchNewBrowserTabBasedOnURL(driver, "Contacts&action");
			 Set<String>set1=driver.getWindowHandles();
				Iterator<String> it1= set1.iterator();
				while(it1.hasNext()) {
					String windowID=it1.next();
					driver.switchTo().window(windowID);
					String actUrl=driver.getCurrentUrl();
					if(actUrl.contains("Contacts&action")){
						break;
					}
					
				}
			 
			 
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			  headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(contactLastName)) {
					System.out.println(contactLastName+" header verified ==PASS");
				}else {
					System.out.println(contactLastName+" header verified is ==FAIL");
				}
				
					
				 
					String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
					System.out.println(actOrgName);
					if(actOrgName.trim().equals(orgName)) {
						System.out.println(orgName+"  information is created==PASS");
					}else {
						System.out.println(orgName+"  information is  not created==FAIL");
					}
					
			 
			 
			 
			 
//			 //verify header msg expected result
//			String actLastName= driver.findElement(By.id("dtlview_Last Name")).getText();
//			if(actLastName.contains(lastName)) {
//				System.out.println(lastName+"information is verified==PASS");
//			}else {
//				System.out.println(lastName+" information is  not verified==FAIL");
//				

		 

		 driver.quit();
		 
		  
		  }
		
	}


