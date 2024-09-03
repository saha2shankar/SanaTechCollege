package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Integer>{
	
	StudentDetails findByUsernameAndPassword(String username, String password);

}
