package com.sana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sana.Utils.MailUtils;

@Controller
public class ContactController {
	
	@Autowired
	private MailUtils mailutils;

	
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String message, Model model) {
		
		mailutils.sendEmail(toEmail, subject, message);
		model.addAttribute("emailmessage","Your Email is Successefully Sended !, Thank you");
		return"redirect:/homepage";
	}
}
