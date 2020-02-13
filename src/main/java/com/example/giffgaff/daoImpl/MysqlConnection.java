package com.example.giffgaff.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;


@Repository
public class MysqlConnection {

	Connection conn;
	public Connection getConnection() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost/student","vipul","password"); 
		}
		catch(Exception e){ 
			System.out.println(e);
		} 
		return conn;
		
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  
}
