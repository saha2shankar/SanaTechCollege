package com.sana.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.Notes;
import com.sana.repository.NotesRepository;
import com.sana.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService{
	
	@Autowired
	private NotesRepository noteRepository;

	@Override
	public void addNotes(Notes notes) {
		noteRepository.save(notes);
		
	}

	@Override
	public void deleteNotes(int id) {
		noteRepository.deleteById(id);
		
	}

	@Override
	public void updateNots(Notes notes) {
	noteRepository.save(notes);
		
	}

	@Override
	public Notes getNotesbyId(int id) {
		
		return noteRepository.findById(id).get();
	}

	@Override
	public List<Notes> getNotesbyPostTime() {
		List<Notes> notes = noteRepository.findAll();
		List<Notes> sortedNotes= notes.stream()
				.sorted((n1,n2) -> n2.getPostdate().compareTo(n1.getPostdate()))
						.collect(Collectors.toList());
		return sortedNotes;
	}

}
