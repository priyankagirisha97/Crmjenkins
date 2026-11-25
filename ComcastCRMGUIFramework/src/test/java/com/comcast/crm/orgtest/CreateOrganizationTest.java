package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

public class CreateOrganizationTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read the common data from property file
		
	
//		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
//
//		Properties pObj=new Properties();
//		pObj.load(fis);
		
		 String BROWSER=fLib.getDataFromPropertiesFile("browser");
		 String URL=fLib.getDataFromPropertiesFile("url");
		 String USERNAME=fLib.getDataFromPropertiesFile("username");
		 String PASSWORD=fLib.getDataFromPropertiesFile("password");
		 
		 String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
		 
//		 //read testscript data from excel file
//		 FileInputStream fis1=new FileInputStream("./testdata/data/TestScriptData.xlsx");
//		 Workbook wb=WorkbookFactory.create(fis1);
//		 Sheet sh=wb.getSheet("org");
//		 Row row=sh.getRow(1);
//		 String orgName=row.getCell(2).toString()+randomInt;
//		 wb.close();
		 
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
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(URL);
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		 //navigate to org module
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 //click on create org
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 //enter all the details and  create new org
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 //verify header msg expected result
		String headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName+" is created==PASS");
		}else {
			System.out.println(orgName+" is  not created==FAIL");
		}
			
		 //verify header orgName expected result
		 //Thread.sleep(4000);
			String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actOrgName.equals(orgName)) {
				System.out.println(orgName+"  is created==PASS");
			}else {
				System.out.println(orgName+"  is  not created==FAIL");
			}
			
		 //logout
		 driver.quit();
		 
		  
		  }

	}
	



