package com.zodiacagefiesta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@GetMapping()
	public String login(@RequestParam(required = false) String home, @RequestParam(required = false) String register) {
		
		if (home != null) {
			return "redirect:/home";
		}
		
		if (register != null) {
			return "redirect:/register";
		}
		
		return "login";
	}
}
