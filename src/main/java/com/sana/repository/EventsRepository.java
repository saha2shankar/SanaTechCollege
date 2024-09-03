package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.Events;

public interface EventsRepository extends JpaRepository<Events, Integer>{

}
