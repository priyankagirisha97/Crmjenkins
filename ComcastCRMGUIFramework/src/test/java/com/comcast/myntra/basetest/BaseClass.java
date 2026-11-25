package com.comcast.myntra.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.myntra.genericutility.ExcelUtility;
import com.comcast.myntra.genericutility.FileUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	
	
	
	public WebDriver driver = null;
	//public  static WebDriver sdriver=null;
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	
	public WebDriverUtility wlib = new WebDriverUtility();
	

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void configBC(@Optional("chrome") String browser) throws IOException {
		System.out.println("----------Lanuch Browser-------------");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		System.out.println("-----------Login-----------");
		//wlib.maximizeBrowser(driver);
		wlib.waitForPageToLoad(driver);
		String url =flib.getDataFromPropertiesFile("url");
		driver.get(url);
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("------close the browser-------");
		driver.quit();
	}

}

