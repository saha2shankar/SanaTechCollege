package com.sana.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sana.models.Vacancy;
import com.sana.service.VacancyService;

@RestController
public class VacancyApi {
	
	@Autowired
	private VacancyService vacancyService;
	
	@GetMapping("/api/vacancy")
	private List<Vacancy> getAllVacancy() {
		return vacancyService.getallVacancybyTime();
	}
	

}
