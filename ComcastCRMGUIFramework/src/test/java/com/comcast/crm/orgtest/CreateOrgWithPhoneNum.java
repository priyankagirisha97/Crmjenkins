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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithPhoneNum {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");

		Properties pObj=new Properties();
		pObj.load(fis);
		
		 String BROWSER=pObj.getProperty("browser");
		 String URL=pObj.getProperty("url");
		 String USERNAME=pObj.getProperty("username");
		 String PASSWORD=pObj.getProperty("password");
		 
		 //generate the random number
		 Random random=new Random();
		 int randomInt=random.nextInt(10000);
		 //wb.close();
		 
		 
		 //read testscript data from excel file
		 FileInputStream fis1=new FileInputStream("./testdata/data/TestScriptData.xlsx");
		 Workbook wb=WorkbookFactory.create(fis1);
		 Sheet sh=wb.getSheet("org");
		 Row row=sh.getRow(7);
		 String orgName=row.getCell(2).toString()+randomInt;
		 String phoneNumber=row.getCell(3).toString();
		  wb.close();
		 
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
	

		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get(URL);
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
		
		 driver.findElement(By.linkText("Organizations")).click();
		 
		 
		 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		 driver.findElement(By.name("accountname")).sendKeys(orgName);
		 driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String actPhNum=driver.findElement(By.id("dtlview_Phone")).getText();
			if(actPhNum.equals(phoneNumber)) {
				System.out.println(phoneNumber+"  is verified==PASS");
			}else {
				System.out.println(phoneNumber+"  is  not verified==FAIL");
			}
		
		 
		 
		 

		 driver.quit();
		 
		  
		  }

	
	}




	
		