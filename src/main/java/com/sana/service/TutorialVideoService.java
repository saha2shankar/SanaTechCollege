package com.sana.service;

import java.util.List;

import com.sana.models.TutorialVideo;

public interface TutorialVideoService {
	
	
	void addTutorialVideo(TutorialVideo tutorialVideo);
	void deleteTutorialVideo(int tid);
	void updateTutorialVideo(TutorialVideo tutorialVideo);
	TutorialVideo getTutorialVideobyId(int tid);
	List<TutorialVideo> getAllTutorialSortedByTimestampDesc();

}
