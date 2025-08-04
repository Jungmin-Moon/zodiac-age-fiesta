package com.zodiacagefiesta.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zodiacagefiesta.entities.Runs;
import com.zodiacagefiesta.repository.RunsRepository;

@Service
public class RunsService {
	
	private RunsRepository runsRepository;
	
	RunsService(RunsRepository runsRepository) {
		this.runsRepository = runsRepository;
	}
	
	
	public List<Runs> getLast10RecentlyStartedRuns(LocalDateTime dateTime) {
		return runsRepository.getLast10StartedRuns(dateTime);
	}
	
	public List<Runs> getLast10RecentlyFinishedRuns(LocalDateTime dateTime) {
		return runsRepository.getLast10CompletedRuns(dateTime);
	}
}
