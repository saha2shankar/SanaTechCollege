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

import com.sana.models.News;
import com.sana.service.NewsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NewsController {
	
	
	@Autowired
	private NewsService service;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("photo");
    }
	
	@GetMapping("/addnews")
	public String getNews(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		return"AddNews";
	}
	
	@PostMapping("/addnews")
	public String postNews(@ModelAttribute News news, Model model,@RequestParam("photo") MultipartFile image ) {
		
		  if (!image.isEmpty()) {
            try {
                Path directoryPath = Path.of("src/main/resources/static/Newsphoto/");
                if (Files.notExists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }

                Path filePath = directoryPath.resolve(image.getOriginalFilename());
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                news.setPhoto(image.getOriginalFilename());
                service.addNews(news);

                model.addAttribute("message", "Event is added !");
                return"redirect:/addnews";
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "File upload failed. Please try again.");
                return"redirect:/getallNews";
            }
        } else {
            model.addAttribute("message", "Please select a file to upload.");
            return"redirect:/addnews";
        }
		
	}
	
	@GetMapping("/getallNews")
	public String getallNews(Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		model.addAttribute("newsList", service.getallNewsbyTime());
		return"ViewAllNews";
	}
	
	@GetMapping("/news/delete")
	public String deleteNews(@RequestParam int id, Model model, HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
		service.deteteNews(id);
		model.addAttribute("deleted Successful !", "deletemessage");
		return"redirect:/getallNews";
		
	}

}
