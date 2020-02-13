package com.example.giffgaff.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Repository;

import com.example.giffgaff.model.SortByMarks;
import com.example.giffgaff.model.Student;
import com.example.giffgaff.serviceImpl.StudServiceImpl;

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
