package com.sana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.StdPost;
import com.sana.models.StudentDetails;

public interface PostRepository extends JpaRepository<StdPost, Integer>{
	
	 List<StdPost> findByStudentDetail(StudentDetails studentDetail);

}
