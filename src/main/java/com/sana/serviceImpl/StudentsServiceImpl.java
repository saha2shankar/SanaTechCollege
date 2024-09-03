package com.sana.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.StudentDetails;
import com.sana.repository.StudentRepository;

@Service
public class StudentsServiceImpl implements com.sana.service.StudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public void addstudent(StudentDetails studentdetails) {
		repo.save(studentdetails);
		
	}

	@Override
	public void deletestudent(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updatestudent(StudentDetails studentdetails) {
		repo.save(studentdetails);
		
	}

	@Override
	public StudentDetails getstudentById(int id) {
	
		return repo.findById(id).get();
	}

	@Override
	public List<StudentDetails> getallstudent() {
		
		return repo.findAll();
	}

	@Override
	public Long countStudents() {
		
		return repo.count();
	}

	@Override
	public StudentDetails login(String username, String password) {
		
		return repo.findByUsernameAndPassword(username, password);
	}

}
