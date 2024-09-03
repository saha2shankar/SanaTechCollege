package com.sana.models;

import java.util.List;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    private String courseName;
    private String courseCode;
    private String description;
    private String CourseHead;
    private String HeadMobile;
    
    @OneToMany(mappedBy = "course")
    private List<StudentDetails> students;
    
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseHead() {
		return CourseHead;
	}

	public void setCourseHead(String courseHead) {
		CourseHead = courseHead;
	}

	public String getHeadMobile() {
		return HeadMobile;
	}

	public void setHeadMobile(String headMobile) {
		HeadMobile = headMobile;
	}

	public List<StudentDetails> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDetails> students) {
		this.students = students;
	}



    
}
