package com.zodiacagefiesta.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zodiacagefiesta.entities.Runs;
import com.zodiacagefiesta.jobs.Jobs;

@Service
public class CharacterJobAssignService {

	//Assigns only 6 jobs to each character
	public void setSixJobs(Runs userRun, List<String> jobs) {
		for (int i = 0; i < jobs.size(); i++) {
			setJobBasedOnIndex(userRun, i, jobs.get(i));
		}
	}
	
	//Method to assign the singular from from the generateOneJobForAll() method
	public void setSingleJob(Runs userRun, String job) {
		userRun.setVaanJobOne(job);
		userRun.setBalthierJobOne(job);
		userRun.setFranJobOne(job);
		userRun.setBaschJobOne(job);
		userRun.setAsheJobOne(job);
		userRun.setPeneloJobOne(job);
	}
	
	//Method to assign twelve jobs to each character; each character being assigned two
	public void setTwelveJobs(Runs userRun, List<String> jobs) {
		for (int i = 0; i < jobs.size(); i++) {
			setJobBasedOnIndexTwelveVariant(userRun, i, jobs.get(i));
		}
	}
	
	//Helper method to assign jobs to characters when there are only six jobs
	private void setJobBasedOnIndex(Runs userRun, int index, String job) {
		switch(index) {
			case 0 -> userRun.setVaanJobOne(job);
			case 1 -> userRun.setBalthierJobOne(job);
			case 2 -> userRun.setFranJobOne(job);
			case 3 -> userRun.setBaschJobOne(job);
			case 4 -> userRun.setAsheJobOne(job);
			case 5 -> userRun.setPeneloJobOne(job);
		}
	}
	
	//Helper method to assign jobs to characters when there are twelve jobs
	private void setJobBasedOnIndexTwelveVariant(Runs userRun, int index, String job) {
		switch(index) {
			case 0 -> userRun.setVaanJobOne(job);
			case 1 -> userRun.setVaanJobTwo(job);
			case 2 -> userRun.setBalthierJobOne(job);
			case 3 -> userRun.setBalthierJobTwo(job);
			case 4 -> userRun.setFranJobOne(job);
			case 5 -> userRun.setFranJobTwo(job);
			case 6 -> userRun.setBaschJobOne(job);
			case 7 -> userRun.setBaschJobTwo(job);
			case 8 -> userRun.setAsheJobOne(job);
			case 9 -> userRun.setAsheJobTwo(job);
			case 10 -> userRun.setPeneloJobOne(job);
			case 11 -> userRun.setPeneloJobTwo(job);
		}
	}
}
