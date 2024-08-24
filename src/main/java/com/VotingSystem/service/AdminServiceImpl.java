package com.VotingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingSystem.entity.Admin;
import com.VotingSystem.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	@Override
	public void saveAdmin(Admin admin) {
		
		adminRepo.save(admin);
		
	}
	@Override
	public List<Admin> adminlist (){
		List<Admin>find = adminRepo.findAll();
		return find;
	}
	@Override
	public Admin findAdminByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return adminRepo.findByUsernameAndPassword(username, password);
	}
	

}
