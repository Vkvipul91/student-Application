package com.example.giffgaff.dao;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.giffgaff.model.Student;

@RunWith(MockitoJUnitRunner.class)
public class StudDaoImplTest {
	
	@Mock
	StudDao studentDaoMock;
	
	@Mock
	Student student;
	
	@Test
	public void testInsertData() {
		studentDaoMock.insertData(student);
	}

	@Test
	public void testFetchData() {
		
	}

	@Test
	public void testGetStudDetail() {
		
	}

	@Test
	public void testHighestMarksStud() {
		
	}

}
