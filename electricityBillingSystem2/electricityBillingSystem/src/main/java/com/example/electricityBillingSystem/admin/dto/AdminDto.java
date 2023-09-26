package com.example.electricityBillingSystem.admin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class AdminDto {
	
	private Long adminId;
	
	@NotBlank(message="Username cannot be blank")
	private String userName;
	@NotBlank(message="Password cannot be blank")
	@Size(min=3,max=30,message="password characters must be between 3 to 15")
	private String userPassword;
	
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	
	
	

}
