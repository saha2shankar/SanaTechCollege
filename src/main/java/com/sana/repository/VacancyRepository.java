package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer>{

}
