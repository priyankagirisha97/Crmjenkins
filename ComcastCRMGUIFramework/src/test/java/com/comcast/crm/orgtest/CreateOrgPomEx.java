package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;
import com.comcast.crm.objectrepositoryutility.Organization;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;

public class CreateOrgPomEx {
	public static void main(String[] args) throws IOException {
		
	
FileUtility fLib=new FileUtility();

ExcelUtility eLib=new ExcelUtility();
JavaUtility jLib=new JavaUtility();

//read the common data from property file


//FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
//
//Properties pObj=new Properties();
//pObj.load(fis);

 String BROWSER=fLib.getDataFromPropertiesFile("browser");
 String URL=fLib.getDataFromPropertiesFile("url");
 String USERNAME=fLib.getDataFromPropertiesFile("username");
 String PASSWORD=fLib.getDataFromPropertiesFile("password");
 
 String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
 
// //read testscript data from excel file
// FileInputStream fis1=new FileInputStream("./testdata/data/TestScriptData.xlsx");
// Workbook wb=WorkbookFactory.create(fis1);
// Sheet sh=wb.getSheet("org");
// Row row=sh.getRow(1);
// String orgName=row.getCell(2).toString()+randomInt;
// wb.close();
 
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
 
// Login lp=PageFactory.initElements(driver,Login.class);
 Login lp=new Login(driver);
// lp.usernameEdt.sendKeys("admin");
// lp.passwordEdt.sendKeys("admin");
// lp.loginBtn.click();
 
// lp.getUsernameEdt().sendKeys("admin");
// lp.getPasswordEdt().sendKeys("admin");
// lp.getLoginBtn().click();
 
 lp.LoginToApp(URL,USERNAME,PASSWORD);
 
 
 //naviagte to orgnization module
 Home hp=new Home(driver) ;
 hp.getOrgLink().click();
 
 //click on create organization button
 Organization cnp=new  Organization(driver);
 cnp.getCreateNewOrgBtn().click();
 
 //enter all the details and crteate new Organization
 CreatingNewOrganization cnop=new CreatingNewOrganization(driver);
 cnop.createOrg(orgName);
 
 //verify header message expected result
 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
  String actOrgName=oip.getHeaderMsg().getText();
 if(actOrgName.contains(orgName)) {
	 System.out.println(orgName +" name is verified==PASS");
 }else {
	 System.out.println(orgName +" name is not verified==FAIL");
	 
 }
 hp.logout();
 
 
 
 
	
 
	

 driver.quit();
	}
}






 
 
