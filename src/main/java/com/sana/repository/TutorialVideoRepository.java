package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.TutorialVideo;

public interface TutorialVideoRepository extends JpaRepository<TutorialVideo, Integer> {

}
