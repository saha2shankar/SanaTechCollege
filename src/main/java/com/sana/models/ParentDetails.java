package com.sana.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Parent")
public class ParentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parentId;

    private String parentFirstName;
    private String parentLastName;
    private String relationshipToStudent;
    private String parentPhoneNumber;
    private String parentEmail;
    
    @OneToOne(mappedBy = "parent")
    private StudentDetails studentdetails;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getRelationshipToStudent() {
		return relationshipToStudent;
	}

	public void setRelationshipToStudent(String relationshipToStudent) {
		this.relationshipToStudent = relationshipToStudent;
	}


	public StudentDetails getStudentdetails() {
		return studentdetails;
	}

	public void setStudentdetails(StudentDetails studentdetails) {
		this.studentdetails = studentdetails;
	}

	public String getParentFirstName() {
		return parentFirstName;
	}

	public void setParentFirstName(String parentFirstName) {
		this.parentFirstName = parentFirstName;
	}

	public String getParentLastName() {
		return parentLastName;
	}

	public void setParentLastName(String parentLastName) {
		this.parentLastName = parentLastName;
	}

	public String getParentPhoneNumber() {
		return parentPhoneNumber;
	}

	public void setParentPhoneNumber(String parentPhoneNumber) {
		this.parentPhoneNumber = parentPhoneNumber;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}
	
    
    
}


