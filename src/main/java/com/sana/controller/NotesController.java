package com.sana.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sana.models.Notes;
import com.sana.service.NotesService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NotesController {

    @Autowired
    private NotesService notesService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("Notespath");
    }
    
    @GetMapping("/notes")
    public String getNotes(Model model, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
    		return"stdlogin";
    	}
    	model.addAttribute("noteList", notesService.getNotesbyPostTime());
    	return"Notes";
    }

    @GetMapping("/addNotes")
    public String getNotesAdd(HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
        return "AddNotes";
    }

    @PostMapping("/addNotes")
    public String postNotesAdd(@ModelAttribute Notes notes, Model model, @RequestParam("Notespath") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                Path directoryPath = Path.of("src/main/resources/static/Notes/");
                if (Files.notExists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }

                Path filePath = directoryPath.resolve(file.getOriginalFilename());
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                notes.setNotespath(file.getOriginalFilename());
                notesService.addNotes(notes);

                model.addAttribute("message", "Notes added successfully!");
                return "redirect:/viewAllNotes";
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "File upload failed. Please try again.");
                return "redirect:/addNotes";
            }
        } else {
            model.addAttribute("message", "Please select a file to upload.");
            return "redirect:/addNotes";
        }
    }

    @GetMapping("/viewAllNotes")
    public String getAllNotes(Model model, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
        model.addAttribute("NoteList", notesService.getNotesbyPostTime());
        return "ViewAllNotes";
    }
    
    @GetMapping("/note/delete")
    public String deleteNotes(@RequestParam int id) {
    	notesService.deleteNotes(id);
    	return"redirect:/viewAllNotes";
    }

   
}
