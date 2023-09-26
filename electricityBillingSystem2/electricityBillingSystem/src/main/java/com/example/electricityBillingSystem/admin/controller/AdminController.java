package com.example.electricityBillingSystem.admin.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.electricityBillingSystem.admin.dto.AdminDto;
import com.example.electricityBillingSystem.admin.dto.BillDto;
import com.example.electricityBillingSystem.admin.dto.CustomerDto;
import com.example.electricityBillingSystem.admin.exception.AdminAlreadyExistsException;
import com.example.electricityBillingSystem.admin.exception.AdminDoesNotExistException;
import com.example.electricityBillingSystem.admin.exception.InvalidCredentialsException;
import com.example.electricityBillingSystem.admin.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminserv;

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/add")
	public ResponseEntity<?> insertAdmin(@RequestBody AdminDto adddto) throws AdminAlreadyExistsException {
		logger.info("saved admin details");
		return new ResponseEntity<AdminDto>(adminserv.insertAdmin(adddto), HttpStatus.CREATED);
	}
	@GetMapping("/adminList")
	public ResponseEntity<List<AdminDto>> viewAllAdmin(){
		logger.info("Fetch Admin List");
		List<AdminDto> allAdminDtos =  adminserv.getAllAdmins();
		logger.info("Admin List Fetched Successfully");
		return new ResponseEntity<>(allAdminDtos,HttpStatus.OK);
	}

	@PutMapping("/updateById/{id}")
	public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id, @RequestBody AdminDto adddto)
			throws AdminDoesNotExistException {
		adddto.setAdminId(id);
		Logger logger = LoggerFactory.getLogger(AdminController.class);
		logger.info("updates admin details");
		return new ResponseEntity<AdminDto>(adminserv.updateAdminById(adddto), HttpStatus.ACCEPTED);
	}

	@GetMapping("/loginAdmin")
	public String loginAdmin(AdminDto ad) throws AdminDoesNotExistException, InvalidCredentialsException {
		logger.info("Login!");
		return adminserv.loginAdmin(ad);
	}



	@DeleteMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable long id) throws AdminDoesNotExistException {
		logger.info("Deleted Succesfully");
		return adminserv.deleteAdmin(id);
	}

	@GetMapping("/getAllCustomers")

	public List<CustomerDto> getAllCustomers() {

		logger.info("Got all customer details");

		return adminserv.getAllCustomers();

	}
	
	@GetMapping("/getAllBills")
	
		public List<BillDto> getAllBills(){
	
		logger.info("got all bill details");
	
		return adminserv.getAllBills();
		}

}
