package com.sana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sana.models.Vacancy;
import com.sana.service.VacancyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VacancyController {
	
	@Autowired
	private VacancyService service;
	
	@GetMapping("/vacancy")
	public String getVacancy(Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		model.addAttribute("vlist", service.getallVacancybyTime());
		return"Vacancy";
	}
	
	
	@GetMapping("/addvacancy")
	public String getAddVacancy(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		return"AddVacancy";
	}
	
	@PostMapping("/addvacancy")
	public String postAddVacancy(@ModelAttribute Vacancy vacancy, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		service.addVacancy(vacancy);
		return"redirect:/getallvacancy";
	}
	
	@GetMapping("/getallvacancy")
	public String getallvacancy(Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		model.addAttribute("vacancyList", service.getallVacancybyTime());
		return"ViewAllVacancy";
	}
	
	
	@GetMapping("/vacancy/delete")
	public String deleteVacancy(@RequestParam int id, Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		service.deleteVacancy(id);
		model.addAttribute("deleteMassage", "Vacancy Successfully Deleted !");
		return"redirect:/getallvacancy";
	}

}
