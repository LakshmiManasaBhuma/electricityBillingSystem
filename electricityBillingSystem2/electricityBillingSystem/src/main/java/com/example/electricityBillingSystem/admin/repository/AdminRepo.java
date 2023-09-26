package com.example.electricityBillingSystem.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.electricityBillingSystem.admin.dto.AdminDto;
import com.example.electricityBillingSystem.admin.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long>{

	AdminDto findByUserName(String userName);
	

}
