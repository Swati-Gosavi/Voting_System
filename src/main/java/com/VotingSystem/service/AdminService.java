package com.VotingSystem.service;

import java.util.List;

import com.VotingSystem.entity.Admin;

public interface AdminService {

	public void saveAdmin(Admin admin);
		
	public List<Admin> adminlist ();

	public Admin findAdminByUsernameAndPassword(String username, String password);

	
	
}
