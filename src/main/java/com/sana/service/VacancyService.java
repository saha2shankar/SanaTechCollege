package com.sana.service;

import java.util.List;

import com.sana.models.Vacancy;

public interface VacancyService {
	
	
	void addVacancy(Vacancy vacancy);
	void deleteVacancy(int id);
	void updateVacancy(Vacancy vacancy);
	List<Vacancy> getallVacancybyTime();
	Long countVacancy();

}
