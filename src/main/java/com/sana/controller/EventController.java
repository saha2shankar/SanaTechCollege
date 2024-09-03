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

import com.sana.models.Events;
import com.sana.service.EventsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EventController {
	
	@Autowired
	private EventsService service;
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("photopath");
    }
	
	@GetMapping("/eventadd")
	public String getEvents(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		return"EventsAdd";
	}
	
	@PostMapping("/eventadd")
	public String postEventsadd( @ModelAttribute Events events, Model model, @RequestParam("photopath") MultipartFile image) {
		
		  if (!image.isEmpty()) {
              try {
                  Path directoryPath = Path.of("src/main/resources/static/Eventsphoto/");
                  if (Files.notExists(directoryPath)) {
                      Files.createDirectories(directoryPath);
                  }

                  Path filePath = directoryPath.resolve(image.getOriginalFilename());
                  Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                  events.setPhotopath(image.getOriginalFilename());
                  service.addEvent(events);

                  model.addAttribute("message", "Event is added !");
                  return "redirect:/getallEvents";
              } catch (IOException e) {
                  e.printStackTrace();
                  model.addAttribute("message", "File upload failed. Please try again.");
                  return "redirect:/eventadd";
              }
          } else {
              model.addAttribute("message", "Please select a file to upload.");
              return "redirect:/eventadd";
          }
	}
	
	@GetMapping("/getallEvents")
	public String getallEvents(Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		model.addAttribute("eventsList", service.getAlleventsbypostDate());
		return"ViewallEvents";
	}
	
	@GetMapping("/event/delete")
	public String deleteevent(@RequestParam int id, Model model) {
		service.deleteEvent(id);
		model.addAttribute("deleteMessage","Events Successfully Deleted !");
		return"redirect:/getallEvents";
	}

}
