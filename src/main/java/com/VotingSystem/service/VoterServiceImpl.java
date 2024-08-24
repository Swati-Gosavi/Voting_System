package com.VotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingSystem.entity.Voter;
import com.VotingSystem.repository.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterRepository voterRepo;
	
	@Override
	public List<Voter> getAllVoters() {
	    return voterRepo.findAll();
	}
	
	@Override
	public Voter saveVoter(Voter voter) {
		
		return voterRepo.save(voter);
	}

	 @Override
	    public Voter findVoterByUsernameAndPassword(String username, String password) {
	        // Implement logic to find a voter by username and password
	        // For example:
	        Optional<Voter> optionalVoter = voterRepo.findByUsernameAndPassword(username, password);
	        return optionalVoter.orElse(null);
	    }

	    @Override
	    public void deleteVoterById(int id) {
	        voterRepo.deleteById(id);
	    }
	

	
	

	
}
