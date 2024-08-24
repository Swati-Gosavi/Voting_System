package com.VotingSystem.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.VotingSystem.entity.Profile;
import com.VotingSystem.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
    private ProfileRepository profileRepository;

    public Profile updateProfile(int id, String name, MultipartFile image) {
        Profile profile = profileRepository.findById(id).orElse(null);
        if (profile != null) {
            if (name != null) {
              
                profile.setName(name); 
            }
            if (image != null) {
                try {
                    profile.setImage(image.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return profileRepository.save(profile);
        }
        return null;
    }
}
