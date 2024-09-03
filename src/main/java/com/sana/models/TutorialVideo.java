package com.sana.models;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TutorialVideo")
public class TutorialVideo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String tutoriallink;
	private String title;
	private String postby;
	private LocalDateTime date;
	private String Filter;
	
	public TutorialVideo() {
		
		this.date =LocalDateTime.now();
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTutoriallink() {
		return tutoriallink;
	}
	public void setTutoriallink(String tutoriallink) {
		this.tutoriallink = tutoriallink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostby() {
		return postby;
	}
	public void setPostby(String postby) {
		this.postby = postby;
	}
	
	public String getFilter() {
		return Filter;
	}
	public void setFilter(String filter) {
		Filter = filter;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	

}
