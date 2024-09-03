package com.sana.service;

import java.util.List;

import com.sana.models.StudentDetails;

public interface StudentService {

	void addstudent(StudentDetails studentdetails);
	void deletestudent(int id);
	void updatestudent(StudentDetails studentdetails);
	StudentDetails getstudentById(int id);
	List<StudentDetails> getallstudent();
	Long countStudents();
	StudentDetails login(String username, String password);
	
}
