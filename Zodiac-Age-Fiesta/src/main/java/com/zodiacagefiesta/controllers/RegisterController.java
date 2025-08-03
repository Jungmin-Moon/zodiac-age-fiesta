package com.zodiacagefiesta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zodiacagefiesta.entities.User;
import com.zodiacagefiesta.services.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private UserService userService;
	
	RegisterController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping()
	public String register() {
		return "register";
	}
	
	@PostMapping() 
	public String registerPost(@ModelAttribute User user, Model model) {
		
		//System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		
		if (userService.createUser(user) == true) {
			return "redirect:/home";
		} else {
			String message = "The username " + user.getUsername() + " was already taken.";
			model.addAttribute("error_message", message);
			return "register";
		}
	}
}
