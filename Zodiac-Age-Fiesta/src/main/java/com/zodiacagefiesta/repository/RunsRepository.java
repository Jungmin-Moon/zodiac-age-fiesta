package com.zodiacagefiesta.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zodiacagefiesta.entities.Runs;

@Repository
public interface RunsRepository extends JpaRepository<Runs, Long>{
	
	@Query("SELECT r FROM Runs r WHERE r.dateTimeStarted <= :dateTime AND r.inProgress = 1 LIMIT 10")
	List<Runs> getLast10StartedRuns(LocalDateTime dateTime);
	
	@Query("SELECT r FROM Runs r WHERE r.dateTimeEnded <= :dateTime AND r.inProgress = 0 LIMIT 10")
	List<Runs> getLast10CompletedRuns(LocalDateTime dateTime);
}
