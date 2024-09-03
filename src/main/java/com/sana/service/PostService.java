package com.sana.service;

import java.util.List;

import com.sana.models.StdPost;

public interface PostService {
	
	void addPost(StdPost stdpost);
	void deletePost(int id);
	void updatePost(StdPost stdpost);
	StdPost getpostbyId(int id);
	List<StdPost> getallPost();
	List<StdPost> getAllPostSortedByTimestampDesc();
	List<StdPost> getPostsByStudentId(int studentId);
	Long countStudentPost();

}
