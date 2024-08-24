package com.VotingSystem.service;

import java.util.List;

import com.VotingSystem.entity.Voter;

public interface VoterService {

	public Voter saveVoter(Voter voter);
	public Voter findVoterByUsernameAndPassword(String username, String password);
	public List<Voter> getAllVoters();
	public void deleteVoterById(int id);
	
}
