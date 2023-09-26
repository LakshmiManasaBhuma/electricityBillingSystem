package com.example.electricityBillingSystem.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.electricityBillingSystem.admin.dto.BillDto;

@FeignClient(name="bill-service",url="http://localhost:8081/bill")
public interface BillAccess {
	
	@GetMapping("/billsList")

	public static ResponseEntity<List<BillDto>> viewAllBill() {
		// TODO Auto-generated method stub
		return null;
		
	}
	

}
