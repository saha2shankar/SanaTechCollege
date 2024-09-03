package com.sana.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.TutorialVideo;
import com.sana.repository.TutorialVideoRepository;
import com.sana.service.TutorialVideoService;

@Service
public class TutorialVideoServiceImpl implements TutorialVideoService{

	@Autowired
	private TutorialVideoRepository repo;
	
	@Override
	public void addTutorialVideo(TutorialVideo tutorialVideo) {
		repo.save(tutorialVideo);
		
	}

	@Override
	public void deleteTutorialVideo(int tid) {
		repo.deleteById(tid);
	}

	@Override
	public void updateTutorialVideo(TutorialVideo tutorialVideo) {
		repo.save(tutorialVideo);	
	}

	@Override
	public TutorialVideo getTutorialVideobyId(int tid) {
		
		return repo.findById(tid).get();
	}

	@Override
	public List<TutorialVideo> getAllTutorialSortedByTimestampDesc() {
	    List<TutorialVideo> tutorials = repo.findAll();
	    List<TutorialVideo> sortedTutorials = tutorials.stream()
	            .sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
	            .collect(Collectors.toList());

	    return sortedTutorials;
	}


}
