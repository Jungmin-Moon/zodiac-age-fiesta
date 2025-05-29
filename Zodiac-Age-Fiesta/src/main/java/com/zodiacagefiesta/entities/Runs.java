package com.zodiacagefiesta.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_runs")
public class Runs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long runId;
	
	private String username;
	
	private String runType;
	
	private String vaanJobOne;
	private String vaanJobTwo;
	
	private String franJobOne;
	private String franJobTwo;
	
	private String balthierJobOne;
	private String balthierJobTwo;
	
	private String baschJobOne;
	private String baschJobTwo;
	
	private String asheJobOne;
	private String asheJobTwo;
	
	private String peneloJobOne;
	private String peneloJobTwo;
	
	private LocalDateTime dateTimeStarted;
	private LocalDateTime dateTimeEnded;
	
	private int inProgress;

	public long getRunId() {
		return runId;
	}

	public void setRunId(long runId) {
		this.runId = runId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRunType() {
		return runType;
	}

	public void setRunType(String runType) {
		this.runType = runType;
	}

	public String getVaanJobOne() {
		return vaanJobOne;
	}

	public void setVaanJobOne(String vaanJobOne) {
		this.vaanJobOne = vaanJobOne;
	}

	public String getVaanJobTwo() {
		return vaanJobTwo;
	}

	public void setVaanJobTwo(String vaanJobTwo) {
		this.vaanJobTwo = vaanJobTwo;
	}

	public String getFranJobOne() {
		return franJobOne;
	}

	public void setFranJobOne(String franJobOne) {
		this.franJobOne = franJobOne;
	}

	public String getFranJobTwo() {
		return franJobTwo;
	}

	public void setFranJobTwo(String franJobTwo) {
		this.franJobTwo = franJobTwo;
	}

	public String getBalthierJobOne() {
		return balthierJobOne;
	}

	public void setBalthierJobOne(String balthierJobOne) {
		this.balthierJobOne = balthierJobOne;
	}

	public String getBalthierJobTwo() {
		return balthierJobTwo;
	}

	public void setBalthierJobTwo(String balthierJobTwo) {
		this.balthierJobTwo = balthierJobTwo;
	}

	public String getBaschJobOne() {
		return baschJobOne;
	}

	public void setBaschJobOne(String baschJobOne) {
		this.baschJobOne = baschJobOne;
	}

	public String getBaschJobTwo() {
		return baschJobTwo;
	}

	public void setBaschJobTwo(String baschJobTwo) {
		this.baschJobTwo = baschJobTwo;
	}

	public String getAsheJobOne() {
		return asheJobOne;
	}

	public void setAsheJobOne(String asheJobOne) {
		this.asheJobOne = asheJobOne;
	}

	public String getAsheJobTwo() {
		return asheJobTwo;
	}

	public void setAsheJobTwo(String asheJobTwo) {
		this.asheJobTwo = asheJobTwo;
	}

	public String getPeneloJobOne() {
		return peneloJobOne;
	}

	public void setPeneloJobOne(String peneloJobOne) {
		this.peneloJobOne = peneloJobOne;
	}

	public String getPeneloJobTwo() {
		return peneloJobTwo;
	}

	public void setPeneloJobTwo(String peneloJobTwo) {
		this.peneloJobTwo = peneloJobTwo;
	}

	public LocalDateTime getDateTimeStarted() {
		return dateTimeStarted;
	}

	public void setDateTimeStarted(LocalDateTime dateTimeStarted) {
		this.dateTimeStarted = dateTimeStarted;
	}

	public LocalDateTime getDateTimeEnded() {
		return dateTimeEnded;
	}

	public void setDateTimeEnded(LocalDateTime dateTimeEnded) {
		this.dateTimeEnded = dateTimeEnded;
	}

	public int getInProgress() {
		return inProgress;
	}

	public void setInProgress(int inProgress) {
		this.inProgress = inProgress;
	}
	
	
}
