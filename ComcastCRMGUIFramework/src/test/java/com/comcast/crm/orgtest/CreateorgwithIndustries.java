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

public class CreateorgwithIndustries {
public static void main(String[] args) throws IOException, InterruptedException {
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
	 Row row=sh.getRow(4);
	 String orgName=row.getCell(2).toString()+randomInt;
	 String industry=row.getCell(3).toString();
	 String type=row.getCell(4).toString();
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
	 WebElement wbsel=driver.findElement(By.name("industry"));
	 Select sel=new Select(wbsel);
	 sel.selectByVisibleText(industry);
	 
	 WebElement wesel1=driver.findElement(By.name("accounttype"));
	 Select sel1=new Select(wesel1);
	 sel1.selectByVisibleText(type);
	 
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 //verify thw drpdwn industry ad type info
	 
	 //verify header msg expected result
//	String headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//	if(headerInfo.contains(orgName)) {
//		System.out.println(orgName+" is created==PASS");
//	}else {
//		System.out.println(orgName+" is  not created==FAIL");
//		
//	 //verify header orgName expected result
//	 //Thread.sleep(4000);
//		String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if(actOrgName.equals(orgName)) {
//			System.out.println(orgName+"  is created==PASS");
//		}else {
//			System.out.println(orgName+"  is  not created==FAIL");
//		} 
		String actualindustries=driver.findElement(By.id("dtlview_Industry")).getText();
		if(actualindustries.equals(industry)) {
			System.out.println(industry+"  is verified==PASS");
		}else {
			System.out.println(actualindustries+"  is  not verified==FAIL");
		}
		Thread.sleep(2000);
		String actualtype=driver.findElement(By.id("dtlview_Type")).getText();
		if(actualtype.equals(type)) {
			System.out.println(type+"  is verified==PASS");
		}else {
			System.out.println(type+"  is  not verified==FAIL");
		}
		
	 //logout
	 driver.quit();
	 
	
}
}
