package com.zodiacagefiesta.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zodiacagefiesta.services.RunGeneratorService;

public class RunGeneratorServiceTests {

	
	@Autowired
	RunGeneratorService runGeneratorService;
	
	
	@Test
	void testSixUniqueJobs() {
		List<String> testJobs = new ArrayList<>();
		
		testJobs = runGeneratorService.generateSixUniqueJobs();
		
		for(String i: testJobs) {
			System.out.println(i);
		}
	}
}
