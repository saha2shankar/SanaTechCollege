package com.sana.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sana.models.Notes;
import com.sana.service.NotesService;

@RestController
public class NotesApi {
	
	@Autowired
	private NotesService notesService;

	@GetMapping("/api/allNotes")
	public List<Notes> getallNotes () {
		return notesService.getNotesbyPostTime();
	}
}
