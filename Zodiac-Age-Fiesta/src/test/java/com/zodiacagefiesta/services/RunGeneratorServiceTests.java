package com.zodiacagefiesta.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
		System.out.println();
	}
	
	@Test
	void testSixJobs() {
		List<String> testJobs = new ArrayList<>();
		
		testJobs = runGeneratorService.generateSixJobs();
		
		for(String i: testJobs) {
			System.out.println(i);
		}
		System.out.println();
	}
	
	@Test
	void testSingleJob() {
		System.out.println(runGeneratorService.generateOneJobForAll() + "\n");
	}
	
	@Test
	void testTwelveUniqueJobs() {
		List<String> testJobs = new ArrayList<>();
		
		testJobs = runGeneratorService.generateTwelveUniqueJobs();
		
		for(String i: testJobs) {
			System.out.println(i);
		}
		
		System.out.println();
	}
}
