package com.sana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sana.models.Admin;
import com.sana.models.StdPost;
import com.sana.service.AdminService;
import com.sana.service.EventsService;
import com.sana.service.PostService;
import com.sana.service.StudentService;
import com.sana.service.VacancyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private PostService postservice;
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private EventsService eventsservice;
	
	@Autowired
	private VacancyService vacancyservice;
	
	@GetMapping("/adminlogin")
	public String getadminlogin() {
		return"adminlogin";
	}
	@PostMapping("/adminlogin")
	public String postadminlogin(@ModelAttribute Admin admin, Model model, HttpSession session) {
		Admin a = service.login(admin.getUsername(), admin.getPassword());
		if(a != null) {
			session.setAttribute("validuser", a);
			session.setMaxInactiveInterval(500);
			return"redirect:/admindashboard";
		
		}else {
			 model.addAttribute("message", "You are not authorized user !");
			return"adminlogin";
			
		}
		
	}
	
	@GetMapping("/admindashboard")
	public String getadminDashboard(HttpSession session, Model model, StdPost post) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		long studentCount = studentservice.countStudents();
		model.addAttribute("studentCount", studentCount);
		
		long vacancyCouent = vacancyservice.countVacancy();
		model.addAttribute("vacancyCount", vacancyCouent);
		
		long eventsCount = eventsservice.countEvents();
		model.addAttribute("eventsCount", eventsCount);
		
		long postCount = postservice.countStudentPost();
		model.addAttribute("postCount", postCount);
		
		model.addAttribute("postList", postservice.getAllPostSortedByTimestampDesc());
		return"dashboard";
	}
	

	@GetMapping("/adminlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"adminlogin";
	}
}
