package com.VotingSystem.service;

import org.springframework.web.multipart.MultipartFile;

import com.VotingSystem.entity.Profile;

public interface ProfileService {

	Profile updateProfile(int id, String name, MultipartFile image);
	
	

}
