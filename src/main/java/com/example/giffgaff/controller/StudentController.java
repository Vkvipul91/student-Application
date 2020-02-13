package com.example.giffgaff.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.giffgaff.model.Student;
import com.example.giffgaff.service.StudService;
import com.example.giffgaff.serviceImpl.StudServiceImpl;

@Controller
public class StudentController {

	
	  @Autowired 
	  StudService studservice;
	 
	
	  @Autowired 
	  Student student;
	 
	  @RequestMapping("/studentApp")
	public String welcomeUser() {    
		  Scanner in = new Scanner(System.in);
	    System.out.println("Please enter student details:");
	    
	    System.out.println("Enter Student ID: ");
		String stud_id = in.nextLine();
		
		System.out.println("Enter Student Name: ");
		String name = in.nextLine();
		
		System.out.println("Enter Student Total Marks: ");
		String total_marks = in.nextLine();
		
				
		student.setStud_id(Integer.parseInt(stud_id));  
		student.setName(name);
		student.setTotal_marks(total_marks);
		int status = studservice.insertData(student);
		if(status != 0)
			System.out.println("Successfully Inserted !!!");
		
		return "Successfully Inserted";
	
	}
}
