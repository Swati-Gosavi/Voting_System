package com.VotingSystem.service;

import java.util.List;

import com.VotingSystem.entity.Election;

public interface ElectionService {

	void saveElection(Election election);

	List<Election> getAllElections();

	void deleteElectionById(int id);

	
}
