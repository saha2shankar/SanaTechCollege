package com.sana.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sana.models.StdPost;
import com.sana.models.StudentDetails;
import com.sana.repository.PostRepository;
import com.sana.repository.StudentRepository;
import com.sana.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository repo;

	 @Autowired
	    private StudentRepository studentDetailsRepository;
	    
	@Override
	public void addPost(StdPost stdpost) {
		repo.save(stdpost);
		
	}

	@Override
	public void deletePost(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updatePost(StdPost stdpost) {
		repo.save(stdpost);
		
	}

	@Override
	public StdPost getpostbyId(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<StdPost> getallPost() {
		
		return repo.findAll();
	}

	@Override
	public List<StdPost> getAllPostSortedByTimestampDesc() {
		List<StdPost> posts = repo.findAll();
		  List<StdPost> sortedPosts = posts.stream()
	                .sorted((p1, p2) -> p2.getPostTime().compareTo(p1.getPostTime()))
	                .collect(Collectors.toList());
		
		return sortedPosts;
	}

	@Override
	public List<StdPost> getPostsByStudentId(int studentId) {
		StudentDetails studentDetail = studentDetailsRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
		
		return repo.findByStudentDetail(studentDetail);
	}

	@Override
	public Long countStudentPost() {
		
		return repo.count();
	}

	

}
