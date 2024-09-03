package com.sana.models;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "StdPost")
public class StdPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postid;

    private String postimg;
    private String caption;
    private LocalDateTime postTime;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentDetails studentDetail;

    public StdPost() {
        this.postTime = LocalDateTime.now();
    }

    // Getters and Setters
    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getPostimg() {
        return postimg;
    }

    public void setPostimg(String postimg) {
        this.postimg = postimg;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public StudentDetails getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetails studentDetail) {
        this.studentDetail = studentDetail;
    }
}
