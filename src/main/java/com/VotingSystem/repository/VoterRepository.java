package com.VotingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VotingSystem.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {

	Optional<Voter> findByUsernameAndPassword(String username, String password);

	

	Voter findByUsername(String username);

	
}
