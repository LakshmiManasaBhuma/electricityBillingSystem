package com.example.electricityBillingSystem;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;





@SpringBootApplication
//@ComponentScan(basePackages = "com.example.electricityBillingSystem.FeignClient.BillAddress")
public class ElectricityBillingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillingSystemApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	

	
	
}
