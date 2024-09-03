package com.sana.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.models.Admin;
import com.sana.repository.AdminRepository;
import com.sana.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository repo;

	@Override
	public Admin login(String username, String password) {
		
		return repo.findByUsernameAndPassword(username, password);
	}
	
}
