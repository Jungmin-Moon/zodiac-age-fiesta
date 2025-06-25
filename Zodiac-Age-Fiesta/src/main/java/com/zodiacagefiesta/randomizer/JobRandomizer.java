package com.zodiacagefiesta.randomizer;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.zodiacagefiesta.jobs.Jobs;

@Component
public class JobRandomizer {
	
	Jobs[] jobs = Jobs.values();
	
	
	
	public String chooseJob() {
		Random r = new Random();
		
		int randomJob = r.nextInt(jobs.length);
		
		String chosenJob = jobsToString(jobs[randomJob]);
		
		return chosenJob;
	}
	
	
	
	private String jobsToString(Jobs job) {
		
		String jobString = "";
		
		jobString = switch(job) {
			case SHIKARI -> "Shikari";
			case RED_BATTLEMAGE -> "Red Battlemage";
			case FOEBREAKER -> "Foebreaker";
			case UHLAN -> "Uhlan";
			case TIME_BATTLEMAGE -> "Time Battlemage";
			case BUSHI -> "Bushi";
			case KNIGHT -> "Knight";
			case MONK -> "Monk";
			case ARCHER -> "Archer";
			case BLACK_MAGE -> "Black Mage";
			case MACHINIST -> "Machinist";
			case WHITE_MAGE -> "White Mage";
		};
		
		
		return jobString;
	}
}
