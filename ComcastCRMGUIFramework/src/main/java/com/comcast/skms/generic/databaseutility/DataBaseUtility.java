package com.comcast.skms.generic.databaseutility;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtility {
	Connection con;
//	public void getDbconnection(String url,String username,String password) {
//		try {
//		Driver driver=new Driver();
//		DriverManager.registerDriver(driver);
//		 con=DriverManager.getConnection(url,username,password);
//		
//	}catch(Exception e) {
//		
//	}
	
	
	public void getDbconnection(String url, String username, String password) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(url, username, password);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
		
//		public void getDbconnection() {
//			try {
//			Driver driver=new Driver();
//			DriverManager.registerDriver(driver);
//		    con=DriverManager.getConnection("                         ");
//			
//		}catch(Exception e) {
	public void getDbconnection() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/yourDatabase",
	            "root",
	            "password"
	        );
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
//				
	


		
	public void closeDbconnection() throws SQLException {
		try {
		con.close();
	}catch(Exception e) {
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet res=null;
		try {
		    Statement stat=con.createStatement();
		     res=stat.executeQuery(query);
		}catch(Exception e) {}
			
		    return res;
		
	
}
	public int executeNonselectQuery(String query) {
		int result=0;
		try {
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
			
		}catch(Exception e) {
			
		}
		return result;
	}
	
}



