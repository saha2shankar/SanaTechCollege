package com.sana.controller;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.sana.models.News;
import com.sana.models.StudentDetails;
import com.sana.service.CourseService;
import com.sana.service.EventsService;
import com.sana.service.NewsService;
import com.sana.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentsController {

    @Autowired
    private StudentService service; // Fixed typo

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private EventsService eservice;
    
    @Autowired
    private NewsService newservice;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("profilpic");
    }

    @GetMapping({ "/", "/studentlogin" })
    public String getStudentLogin() {
        return "stdlogin";
    }

    @PostMapping("/studentlogin")
    public String postStudentLogin(@ModelAttribute StudentDetails studentDetails, Model model, HttpSession session) {
        StudentDetails s = service.login(studentDetails.getUsername(), studentDetails.getPassword());
        if (s != null) {
        	session.setAttribute("validuser", s);
        	session.setMaxInactiveInterval(500);
            model.addAttribute("message", "Login Success !");
            return "redirect:/homepage";
        } else {
            model.addAttribute("message", "Username or password is incorrect !");
            return "stdlogin";
        }
    }

    @GetMapping("/studentadd")
    public String getStudentAdd(Model model, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
    		return"stdlogin";
    	}
        model.addAttribute("clist", courseService.getallCourse());
        return "StudentAdd";
    }

    @PostMapping("/studentadd")
    public String postStudentAdd(@ModelAttribute StudentDetails studentDetails,
                                 @RequestParam("profilpic") MultipartFile image, Model model) {

        if (!image.isEmpty()) {
            try {
                Path directoryPath = Path.of("src/main/resources/static/StudentProfilepicture/");
                if (Files.notExists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }

                Path filePath = directoryPath.resolve(image.getOriginalFilename());
                Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                studentDetails.setProfilpic(image.getOriginalFilename());
                
                try {
                	service.addstudent(studentDetails);
                } catch (DataIntegrityViolationException e) {
             System.out.println("Duplicate entry detected: " + e.getMessage());
                }


                model.addAttribute("message", "Student Added successfully !");
                return "redirect:/allstudents";
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "File upload failed. Please try again.");
                return "redirect:/studentadd";
            }
        } else {
            model.addAttribute("message", "Please select a file to upload.");
            return "redirect:/studentadd";
        }
    }
    
    
    @GetMapping("/profile")
   public String getPorfilepage(@RequestParam int studentId, Model model, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
    		return"stdlogin";
    	}
    	
   	 model.addAttribute("student", service.getstudentById(studentId));
	   return"profile";
   }
    
    @GetMapping("/stdlogout")
    private String studentlogout(HttpSession session) {
    	session.invalidate();
    	
    	return"stdlogin";
    }
    
    @GetMapping("/homepage")
    private String homepage(HttpSession session, Model model, Events event, News news) {
    	if(session.getAttribute("validuser")==null) {
    		return"stdlogin";
    	}
    	 List<Events> events = eservice.getAlleventsbypostDate();
         model.addAttribute("eventList", events);
         List<News> newss = newservice.getallNewsbyTime();
         model.addAttribute("newsList", newss);
    	return"homepage";
    }
    
    
    @GetMapping("/allstudents")
    private String getallStudent(Model model , HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
    	model.addAttribute("studentList", service.getallstudent());
    	return"ViewAllStudent";
    }
    
    @GetMapping("/student/view")
	public String viewStudent(@RequestParam int studentId, Model model, HttpSession session) {
    	if(session.getAttribute("validuser")==null) {
			return"adminlogin";
		}
    	model.addAttribute("student", service.getstudentById(studentId));
		return"stdprofile";
	}
    
}
