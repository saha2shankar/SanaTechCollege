package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
