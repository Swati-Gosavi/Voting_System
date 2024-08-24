package com.VotingSystem.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String electionName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date electionDate;
    private String details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getElectionName() {
		return electionName;
	}
	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}
	public Date getElectionDate() {
		return electionDate;
	}
	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Election(int id, String electionName, Date electionDate, String details) {
		super();
		this.id = id;
		this.electionName = electionName;
		this.electionDate = electionDate;
		this.details = details;
	}
	@Override
	public String toString() {
		return "Election [id=" + id + ", electionName=" + electionName + ", electionDate=" + electionDate + ", details="
				+ details + "]";
	}
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}


