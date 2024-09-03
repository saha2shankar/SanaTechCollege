package com.sana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sana.models.Course;
import com.sana.service.CourseService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	
	@GetMapping("/courseadd")
	public String getcourseadd(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		return"CourseAdd";
	}

	
	@PostMapping("/courseadd")
	public String postcourseadd(@ModelAttribute Course course, Model model) {
		service.addcourse(course);
		return"redirect:getallcourse";
	}
	
	@GetMapping("/getallcourse")
	public String getallcourse(Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		model.addAttribute("courseList", service.getallCourse());
		return"ViewALlCourse";
	}
}
