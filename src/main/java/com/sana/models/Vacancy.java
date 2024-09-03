package com.sana.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vacancy")
public class Vacancy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;
	private String logolink;
	private String address;
	private String post;
	private String category;
	private String description;
	private LocalDateTime postdate;
	private LocalDateTime deadline;
	private String applylink;
	private String joblevel;
	private String salary;
	private String jobtime;
	
	
	public Vacancy() {
		this.postdate = LocalDateTime.now();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getLogolink() {
		return logolink;
	}


	public void setLogolink(String logolink) {
		this.logolink = logolink;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getPostdate() {
		return postdate;
	}


	public void setPostdate(LocalDateTime postdate) {
		this.postdate = postdate;
	}


	public LocalDateTime getDeadline() {
		return deadline;
	}


	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}


	public String getApplylink() {
		return applylink;
	}


	public void setApplylink(String applylink) {
		this.applylink = applylink;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getJoblevel() {
		return joblevel;
	}


	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getJobtime() {
		return jobtime;
	}


	public void setJobtime(String jobtime) {
		this.jobtime = jobtime;
	}
	
	
	
	

}
