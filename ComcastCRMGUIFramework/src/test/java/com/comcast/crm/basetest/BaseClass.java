package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;

public class BaseClass {
	 public DataBaseUtility dbLib=new DataBaseUtility();
	
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver=null;
	
	
	
	@BeforeSuite
	public void configBS() {
		System.out.println("===connect to Db===,report config");
		dbLib.getDbconnection();
		
	}
	
	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("===launch the browser===");
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		
		 if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver();
		 }else if(BROWSER.equals("edge")){
		     driver=new EdgeDriver();
		 }else{
			 driver=new ChromeDriver();
		 }
	
	}
	
	@BeforeMethod
	public void  configBM() throws IOException {
		System.out.println("===login in===");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
//		String URL=fLib.getDataFromPropertiesFile("url");
		
	 	Login lp=new Login(driver);
	 	lp.LoginToApp(URL, USERNAME, PASSWORD);
		
		
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("===logout===");
		Home hp=new Home(driver);
		hp.logout();
		
		}
	@AfterClass
	public void configAC() {
		System.out.println("====close the browser===");
		driver.quit();
	}
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("===close DB,,report backup===");
		dbLib.closeDbconnection();
		
	}

}
