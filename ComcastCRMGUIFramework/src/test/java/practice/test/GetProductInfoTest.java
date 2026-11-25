
package practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductinfoTest(String brandName, String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String x="//span[text()='productName']"
				+ "/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price']";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility eLib=new  ExcelUtility();
		int rowCount=eLib.getRowCount("product");
		
		Object[][] objArr=new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++) {
			
		
			objArr[i][0]=eLib.getDataFromExcel("product", i+1, 0);
			objArr[i][0]=eLib.getDataFromExcel("product", i+1, 1);
		}
//		objArr[0][1]="Apple iPhone 17 Pro Max, US Version, 256GB, eSIM, Cosmic Orange- Unlocked (Renewed)";
		
//		objArr[1][0]="iphone";
//		objArr[1][1]="Apple iPhone 16 Plus, 128GB, Pink - Unlocked (Renewed)";
//		
//		objArr[2][0]="varun";
//		objArr[2][1]="davan";
		
		return objArr;
	}

}
