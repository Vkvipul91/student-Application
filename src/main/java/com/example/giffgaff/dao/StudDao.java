package com.example.giffgaff.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.giffgaff.model.Student;


public interface StudDao {

	public int insertData(Student student);
	public List<Student> fetchData();
	public Student getStudDetail(int id);
	public Student highestMarksStud();
}
