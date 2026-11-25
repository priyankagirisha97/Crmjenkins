package practice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class VerifyProjectName {
	public static void main(String[] args) throws InterruptedException, SQLException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.29.4:8091/");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999",Keys.ENTER);
				//adding project
		driver.findElement(By.linkText("Projects")).click();
		Thread.sleep(5000);
	
	   driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	   driver.findElement(By.name("projectName")).clear();
	   Random r=new Random();
	   String pname="asda"+r.nextInt();
	   driver.findElement(By.name("projectName")).sendKeys(pname);
	   driver.findElement(By.name("createdBy")).clear();
	   driver.findElement(By.name("createdBy")).sendKeys("Malli");
	   
	   Select status=new Select(driver.findElement(By.xpath("//label[text()='Project Status* ']/following-sibling::select[@name='status']")));
	   status.selectByIndex(2);
	   driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	   Thread.sleep(2000);
	   driver.quit();
	   
	   //database connection
	   Driver d=new Driver();
	   DriverManager.registerDriver(d);
	   Connection conn=DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
	   Statement stat = conn.createStatement();
	   ResultSet result=stat.executeQuery("select * from project where project_name'"+pname+"';");
	   boolean flag=false;
	   while(result.next()) {
		   flag=true;
		  // System.out.println("Verified in DB ->PID: " +result.getString(project_id) + | Name: " + result.getString("project_name"));
		   System.out.println("Verified in DB -> PID: " 
				    + result.getString("project_id") 
				    + " | Name: " 
				    + result.getString("project_name"));
		   if(flag)
		   {
		       System.out.println("Project is available in Database");
		   }
		   else
		   {
		       System.out.println("Project is not available in Database");
		   }

		   result.close();
		   stat.close();
		   conn.close();
	   }
	   
	   
	   
		
		
	}

}
