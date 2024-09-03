package com.sana.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sana.models.StudentDetails;
import com.sana.service.StudentService;

@RestController
public class studentApi {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/list")
	public List<StudentDetails> getallStudent(){
		return studentService.getallstudent();	}
	
	

}
