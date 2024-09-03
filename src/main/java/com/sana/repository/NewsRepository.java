package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.News;

public interface NewsRepository extends JpaRepository<News, Integer>{

}
