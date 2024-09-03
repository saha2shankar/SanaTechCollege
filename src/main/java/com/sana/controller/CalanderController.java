package com.sana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalanderController {
	
	
	@GetMapping("/calanderview")
	public String getCalander() {
		return"Calendar";
	}
	

}
