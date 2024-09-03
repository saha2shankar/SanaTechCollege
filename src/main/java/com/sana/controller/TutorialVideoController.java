package com.sana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sana.models.TutorialVideo;
import com.sana.service.TutorialVideoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TutorialVideoController {
	
	@Autowired
	private TutorialVideoService service;
	
	
    @GetMapping("/tutorialvideo")
    private String getTutorialVideo(Model model, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
    	model.addAttribute("tlist", service.getAllTutorialSortedByTimestampDesc());
    	return"TutorialVideo";
    }
    
    
    @GetMapping("/addtutorialvideo")
    private String addtutorialvideo(HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
    	return"AddTutorialVIdeo";
    }
    
    
    @PostMapping("/addtutorialvideo")
    private String postaddtutorialvideo(@ModelAttribute TutorialVideo tvideo, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
    	service.addTutorialVideo(tvideo);
    	return"redirect:/getallTutorialVideo";
    }
	
	
	
	@GetMapping("/getallTutorialVideo")
	public String getallvideo(Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		model.addAttribute("turorialList", service.getAllTutorialSortedByTimestampDesc());
		return"ViewAllTutorialVideo";
	}

	@GetMapping("/tutorial/delete")
	public String deleteTurorialVideo(@RequestParam int tid, Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		service.deleteTutorialVideo(tid);
		model.addAttribute("deleteMessage", "Video Deleted success !");
		return"redirect:/getallTutorialVideo";
	}
}
