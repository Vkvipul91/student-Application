package com.example.giffgaff.controller;

import java.util.Iterator;
import java.util.List;
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
	public String welcomeUser(Model model) {    
		  
		  System.out.println("Please choose the required option from below");
		  System.out.println("1. Show All The Student Details");
		  System.out.println("2. Show Student Details");
		  System.out.println("3. Show Highest Marks Student");
		  System.out.println("4. Add new student Student");
		  Scanner in = new Scanner(System.in);
		  
		  int option = Integer.parseInt(in.next()); 
	  
	        switch (option) { 
	        case 1: 
	        	getAllStudentData();
	            break; 
	        case 2: 
	        	getStudent();
	            break; 
	        case 3: 
	        	getTopStudent();
	            break; 
	        case 4: 
	        	addStudent();
	            break; 
	        
	        default: 
	            System.out.println("Please Select Required Option");
	            break; 
	        } 
	        
	        model.addAttribute("name", "WELCOME TO STUDENT APPLICATION");
	        return "Success";
	     
		}
	  
	 
	public void addStudent() {
		  
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
	  }
	  
	  public void getAllStudentData() {
		  System.out.println("######## Student Details #########");
		  List<Student> students = studservice.fetchData();
		  System.out.println("SID\t"+"SName\t"+"Marks\t");
		  System.out.println("=======================");		  
		  for (Student student : students) {
			System.out.print(student.getStud_id()+"\t"+student.getName()+"\t"+student.getTotal_marks());
			System.out.println();
		}
		  
		System.out.println("######## Student Datetails #########");
		  
	  }
	  
	  public void getTopStudent() {
		  
		  System.out.println("Please find the top Student Details below");
		  
		  Student topStudent = studservice.highestMarksStudent();
		  
		  System.out.println("SID\t"+"SName\t"+"Marks\t");
		  System.out.println("=======================");		  
		  System.out.print(topStudent.getStud_id()+"\t"+topStudent.getName()+"\t"+topStudent.getTotal_marks());
		  System.out.println("Student details has been serialized !!");
		  
		  
	  }
	  
	  public void getStudent() {
		  
		  
		 System.out.println("Please enter student ID");
		 Scanner in = new Scanner(System.in);
		 
		 String id = in.nextLine();
		  
		  System.out.println("Please find the entered Student Details below");
		  
		  
		  Student studentDetails = studservice.getStudDetail(Integer.parseInt(id));
		  
		  System.out.println("SID\t"+"SName\t"+"Marks\t");
		  System.out.println("=======================");
		  
		  System.out.println(studentDetails.getStud_id()+"\t"+studentDetails.getName()+"\t"+studentDetails.getTotal_marks());
		  
	  }
}
