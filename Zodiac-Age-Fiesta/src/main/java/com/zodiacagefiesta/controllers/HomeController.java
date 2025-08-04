package com.zodiacagefiesta.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zodiacagefiesta.services.RunsService;

@Controller
@RequestMapping("home")
public class HomeController {

	private RunsService runsService;
	
	HomeController(RunsService runsService) {
		this.runsService = runsService;
	}
	
	@GetMapping
	public String home(@RequestParam(required = false) String login, @RequestParam(required = false) String register, Model model) {
		
		if (login != null) {
			return "redirect:/login";
		} 
		
		if (register != null) {
			return "redirect:/register";
		}
		
		var last10StartedRuns = runsService.getLast10RecentlyStartedRuns(LocalDateTime.now());
		var last10FinishedRuns = runsService.getLast10RecentlyFinishedRuns(LocalDateTime.now());
		
		model.addAttribute("currentRunsLimit10", last10StartedRuns);
		model.addAttribute("finishedRunsLimit10", last10FinishedRuns);
		
		return "home.html";
	}
}
