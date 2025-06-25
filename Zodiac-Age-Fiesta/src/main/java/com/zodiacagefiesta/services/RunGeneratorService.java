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
	
	
}
