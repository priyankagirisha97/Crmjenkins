package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowRoot {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
//		WebElement parent=driver.findElement(By.xpath("//div[@class='my-3'][1]"));
//		SearchContext p=parent.getShadowRoot();
//		p.findElement(By.cssSelector("input[placeholder='Enter your username']")).clear();
//		p.findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("abc");
//		
//		SearchContext p1=driver.findElement(By.xpath("//div[@class='my-3'][2]")).getShadowRoot();
//		p1.findElement(By.cssSelector("input[placeholder='Enter your password']")).clear();
//		Thread.sleep(3000);
//		p1.findElement(By.cssSelector("input[placeholder='Enter your password']")).sendKeys("xyz");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@type='submit']")).submit();
//		driver.quit();
		
		Actions act=new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//h1[text()='Login']")),Keys.TAB,"Abc",Keys.TAB,"Xyz",Keys.ENTER).perform();
		driver.quit();
		
		
		
		
		

		
		
		
		
		
		
	}

}
