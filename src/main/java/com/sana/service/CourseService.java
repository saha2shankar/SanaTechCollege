package com.sana.service;

import java.util.List;

import com.sana.models.Course;

public interface CourseService {
	
	void addcourse(Course course);
	void deletecoures(int id);
	void updatecourse(Course course);
	Course getCourseById(int id);
	List<Course> getallCourse();

}
