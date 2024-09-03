package com.sana.models;

import java.sql.Date;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String profilpic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private StudentsAddress studentsaddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId")
    private ParentDetails parent;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @OneToMany(mappedBy = "studentDetail")
    private List<StdPost> stdpost;
    
    
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enrollmentId")
    private Enrollment enrollment;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilpic() {
		return profilpic;
	}

	public void setProfilpic(String profilpic) {
		this.profilpic = profilpic;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public StudentsAddress getStudentsaddress() {
		return studentsaddress;
	}

	public void setStudentsaddress(StudentsAddress studentsaddress) {
		this.studentsaddress = studentsaddress;
	}

	public ParentDetails getParent() {
		return parent;
	}

	public void setParent(ParentDetails parent) {
		this.parent = parent;
	}


	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}


	public List<StdPost> getStdpost() {
		return stdpost;
	}

	public void setStdpost(List<StdPost> stdpost) {
		this.stdpost = stdpost;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	

 
    
    
}
