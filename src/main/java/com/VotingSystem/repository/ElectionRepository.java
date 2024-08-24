package com.VotingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VotingSystem.entity.Election;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer>
{

	Optional<Election> findById(Long id);

	void deleteById(Long id);
	

}
