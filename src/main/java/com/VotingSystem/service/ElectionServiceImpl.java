package com.VotingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.VotingSystem.entity.Election;
import com.VotingSystem.repository.ElectionRepository;

@Service
public class ElectionServiceImpl implements ElectionService {
	
	@Autowired
	private ElectionRepository electionRepository;

	@Override
	public void saveElection(Election election) {
		electionRepository.save(election);
	}

	@Override
	public List<Election> getAllElections() {
		return electionRepository.findAll();
	}

	@Override
	public void deleteElectionById(int id) {
		Optional<Election> election = electionRepository.findById(id);
		if (election.isPresent()) {
			electionRepository.deleteById(id);
		} else {
			throw new RuntimeException("Election not found for id :: " + id);
		}
	}
}
