package com.sana.controller;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sana.models.StdPost;
import com.sana.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	  @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        binder.setDisallowedFields("postimg");
	    }
	
    @GetMapping("/post")
    public String getPost(Model model, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
    		return"stdlogin";
    	}
    	List<StdPost> posts = postservice.getAllPostSortedByTimestampDesc();
    	 model.addAttribute("postlist", posts);
    	return"post";
    }
	
    @PostMapping("/post")
    public String postPost(@ModelAttribute StdPost stdpost, Model model, @RequestParam("postimg") MultipartFile image) {
    	  if (!image.isEmpty()) {
              try {
                  Path directoryPath = Path.of("src/main/resources/static/StudentPost/");
                  if (Files.notExists(directoryPath)) {
                      Files.createDirectories(directoryPath);
                  }

                  Path filePath = directoryPath.resolve(image.getOriginalFilename());
                  Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                  stdpost.setPostimg(image.getOriginalFilename());
                  postservice.addPost(stdpost);

                  model.addAttribute("message", "Your post is public !");
                  return "redirect:/post";
              } catch (IOException e) {
                  e.printStackTrace();
                  model.addAttribute("message", "File upload failed. Please try again.");
                  return "redirect:/post";
              }
          } else {
              model.addAttribute("message", "Please select a file to upload.");
              return "redirect:/post";
          }
    }
    
    @GetMapping("/post/delete")
    public String deletePost(@RequestParam int postid) {
    	postservice.deletePost(postid);
    	return"redirect:/admindashboard";
    }
	

}