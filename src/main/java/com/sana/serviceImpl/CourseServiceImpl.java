package com.sana.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.Course;
import com.sana.repository.CourseRepository;
import com.sana.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository repo;

	@Override
	public void addcourse(Course course) {
	repo.save(course);	
	}

	@Override
	public void deletecoures(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updatecourse(Course course) {
		repo.save(course);
		
	}

	@Override
	public Course getCourseById(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<Course> getallCourse() {
		
		return repo.findAll();
	}

}
