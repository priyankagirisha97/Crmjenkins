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

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import org.testng.annotations.Test;



import com.mysql.cj.jdbc.Driver;

public class tc001_sqlDatabaseNinzaHrm {

	@Test

	public void test() throws SQLException {

		

		WebDriver driver = new EdgeDriver();

		Connection con = null;

		try {

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



		// 1. Login to Ninza HRM

		driver.get("http://49.249.29.4:8091/");

		driver.findElement(By.id("username")).clear();

		driver.findElement(By.id("username")).sendKeys("rmgyantra");

		driver.findElement(By.id("inputPassword")).clear();

		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999", Keys.ENTER);



		// 2. Navigate to Projects and create a new project

		driver.findElement(By.linkText("Projects")).click();

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		Random r = new Random();

		String projectName = "priyu"+r.nextInt(1000);

		driver.findElement(By.name("projectName")).clear();

		driver.findElement(By.name("projectName")).sendKeys(projectName);

		

		driver.findElement(By.name("createdBy")).clear();

		driver.findElement(By.name("createdBy")).sendKeys("Malli");



		Select status = new Select(driver.findElement(By.xpath("//label[text()='Project Status* ']/following-sibling::select[@name='status']")));

		status.selectByIndex(2);

		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		

		// 3. Connect to MySQL Database and verify

		Driver d = new Driver();

		DriverManager.registerDriver(d);

		con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");

	

		Statement statement = con.createStatement();

		ResultSet result = statement.executeQuery("select * from project where project_name='"+projectName+"';");

		

		boolean flag = false;

		while (result.next()) {

			flag = true;

			System.out.println("Verified in DB -> PID: " + result.getString("project_id") + " | Name: "

					+ result.getString("project_name"));

		}



		// TestNG Assertion to fail the test if not found in DB

		Assert.assertTrue(flag, "Project '" + projectName + "' was NOT created in the database!");

		System.out.println("Project created successfully");



	} finally {

		if (con != null) {

			con.close();

		}

		driver.quit();

	}

	}

}