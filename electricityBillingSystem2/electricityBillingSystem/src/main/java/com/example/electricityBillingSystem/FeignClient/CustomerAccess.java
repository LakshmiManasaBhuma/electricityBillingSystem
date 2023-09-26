package com.example.electricityBillingSystem.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.electricityBillingSystem.admin.dto.CustomerDto;
@FeignClient(name="customer-service",url="http://localhost:8082/customer")
public interface CustomerAccess {
	
	@GetMapping("/customersList")

	public static ResponseEntity<List<CustomerDto>> viewAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
