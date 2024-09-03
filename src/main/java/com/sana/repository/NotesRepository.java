package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer>{

}
