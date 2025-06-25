package com.zodiacagefiesta.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zodiacagefiesta.randomizer.JobRandomizer;

@Service
public class RunGeneratorService {

	
	JobRandomizer jobRandomizer;
	
	RunGeneratorService(JobRandomizer jobRandomizer) {
		this.jobRandomizer = jobRandomizer;
	}
	
	//Generates six unique jobs that the user can only use those six
	public List<String> generateSixUniqueJobs() {
		List<String> sixUniqueJobs = new ArrayList<>();
		
		for (int i = 0; i < 6; i++) {
			
			String newJob = jobRandomizer.chooseJob();
			
			while(sixUniqueJobs.contains(newJob)) {
				newJob = jobRandomizer.chooseJob();
			} 
			
			sixUniqueJobs.add(newJob);
		}
		
		return sixUniqueJobs;
	}
	
	//Generates six jobs and only those six jobs can be used on the six characters
	public List<String> generateSixJobs() {
		List<String> sixJobs = new ArrayList<>();
		
		for (int i = 0; i < 0; i++) {
			sixJobs.add(jobRandomizer.chooseJob());
		}
		
		return sixJobs;
	}
	
	//Generates a single job for every character to use
	public String generateOneJobForAll() {
		return jobRandomizer.chooseJob();
	}
	
	//Generates a list of the 12 jobs in random order to assigned two to each character
	public List<String> generateTwelveUniqueJobs() {
		List<String> twelveUniqueJobs = new ArrayList<>();
		
		for (int i = 0; i< 12; i++) {
			String newJob = jobRandomizer.chooseJob();
			
			while(twelveUniqueJobs.contains(newJob)) {
				newJob = jobRandomizer.chooseJob();
			}
		}
		
		return twelveUniqueJobs;
	}
	
	
}
