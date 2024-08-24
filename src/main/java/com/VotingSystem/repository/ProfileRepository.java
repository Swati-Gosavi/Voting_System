package com.VotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VotingSystem.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	

}
