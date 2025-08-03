package com.zodiacagefiesta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zodiacagefiesta.entities.User;

@Controller
@RequestMapping("/register")
public class RegisterController {

	
	@GetMapping()
	public String register() {
		return "register";
	}
	
	@PostMapping() 
	public String registerPost(User user, Model model) {
		
		
		
	}
}
