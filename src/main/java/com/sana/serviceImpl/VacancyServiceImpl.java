package com.sana.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.Vacancy;
import com.sana.repository.VacancyRepository;
import com.sana.service.VacancyService;

@Service
public class VacancyServiceImpl implements VacancyService{
	
	
	@Autowired
	private VacancyRepository repo;

	@Override
	public void addVacancy(Vacancy vacancy) {
		repo.save(vacancy);
	}

	@Override
	public void deleteVacancy(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public void updateVacancy(Vacancy vacancy) {
		repo.save(vacancy);
		
	}

	@Override
	public List<Vacancy> getallVacancybyTime() {
		List<Vacancy> vacancys = repo.findAll();
		List<Vacancy> sortedVacancys = vacancys.stream().sorted((v1, v2) -> v2.getPostdate().compareTo(v1.getPostdate())).collect(Collectors.toList());
		return sortedVacancys;
	}

	@Override
	public Long countVacancy() {
		
		return repo.count();
	}

}
