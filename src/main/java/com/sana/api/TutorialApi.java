package com.sana.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sana.models.TutorialVideo;
import com.sana.service.TutorialVideoService;

@RestController
public class TutorialApi {
	@Autowired
	private TutorialVideoService  tutorialVideoService;
	
	@GetMapping("/api/tutorialVideo")
	public List<TutorialVideo> getallToutrialVideo() {
		return tutorialVideoService.getAllTutorialSortedByTimestampDesc();
	}

}
