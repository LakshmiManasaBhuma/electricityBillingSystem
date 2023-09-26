package com.example.electricityBillingSystem.admin.service;





import java.util.List;


import com.example.electricityBillingSystem.admin.dto.AdminDto;
import com.example.electricityBillingSystem.admin.dto.BillDto;
import com.example.electricityBillingSystem.admin.dto.CustomerDto;
import com.example.electricityBillingSystem.admin.entity.Admin;
import com.example.electricityBillingSystem.admin.exception.AdminAlreadyExistsException;
import com.example.electricityBillingSystem.admin.exception.AdminDoesNotExistException;
import com.example.electricityBillingSystem.admin.exception.InvalidCredentialsException;

public interface AdminService {

	AdminDto insertAdmin(AdminDto adddto) throws AdminAlreadyExistsException;
	
	List<AdminDto> getAllAdmins();

	

	String loginAdmin(AdminDto ad) throws AdminDoesNotExistException, InvalidCredentialsException ;

	String deleteAdmin(long id) throws AdminDoesNotExistException;



	AdminDto updateAdminById(AdminDto adddto) throws AdminDoesNotExistException;



	List<CustomerDto> getAllCustomers();



	List<BillDto> getAllBills();




	
	
	

	


	

	

//	List<BillDto> getAllBills();
	

	
	

	
	
	

	
	

	
	

}
