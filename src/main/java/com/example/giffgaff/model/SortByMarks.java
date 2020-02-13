package com.example.giffgaff.model;

import java.util.Comparator;

public class SortByMarks implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		System.out.println(s1.getName()+" "+s2.getName());
		return s2.getTotal_marks().compareTo(s1.getTotal_marks());
	}

}
