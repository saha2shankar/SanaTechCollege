package com.sana.models;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String description;
	private String Notespath;
	private String postby;
	private LocalDateTime postdate;
	
	public Notes() {
		this.postdate = LocalDateTime.now();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPostby() {
		return postby;
	}
	public void setPostby(String postby) {
		this.postby = postby;
	}
	
	public String getNotespath() {
		return Notespath;
	}
	public void setNotespath(String notespath) {
		Notespath = notespath;
	}
	public LocalDateTime getPostdate() {
		return postdate;
	}
	public void setPostdate(LocalDateTime postdate) {
		this.postdate = postdate;
	}
	
	
	

}
