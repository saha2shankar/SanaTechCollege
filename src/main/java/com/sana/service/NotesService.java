package com.sana.service;

import java.util.List;

import com.sana.models.Notes;

public interface NotesService {
	
	void addNotes(Notes notes);
	void deleteNotes(int id);
	void updateNots(Notes notes);
	Notes getNotesbyId(int id);
	List<Notes> getNotesbyPostTime();

}
