package com.sana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sana.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	 Admin findByUsernameAndPassword(String username, String password);

}
