package com.example.electricityBillingSystem.admin.service;

import java.util.List;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.electricityBillingSystem.FeignClient.BillAccess;
import com.example.electricityBillingSystem.FeignClient.CustomerAccess;
import com.example.electricityBillingSystem.admin.dto.AdminDto;
import com.example.electricityBillingSystem.admin.dto.BillDto;
import com.example.electricityBillingSystem.admin.dto.CustomerDto;
import com.example.electricityBillingSystem.admin.entity.Admin;
import com.example.electricityBillingSystem.admin.exception.AdminAlreadyExistsException;
import com.example.electricityBillingSystem.admin.exception.AdminDoesNotExistException;
import com.example.electricityBillingSystem.admin.exception.InvalidCredentialsException;
import com.example.electricityBillingSystem.admin.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepo adminrepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AdminDto insertAdmin(AdminDto adddto) throws AdminAlreadyExistsException {
		Optional<Admin> opt = adminrepo.findById(adddto.getAdminId());

		if (opt.isPresent()) {

			throw new AdminAlreadyExistsException();

		}

		Admin a = mapper.map(adddto, Admin.class);

		a.setUserPassword(passwordEncoder.encode(adddto.getUserPassword()));

		return mapper.map(adminrepo.save(a), AdminDto.class);

	}

	@Override
	public String loginAdmin(AdminDto ad) throws AdminDoesNotExistException, InvalidCredentialsException {
		AdminDto opt = adminrepo.findByUserName(ad.getUserName());
		if (opt != null) {
			if (opt.getUserName().equals(ad.getUserName())
					&& (passwordEncoder.matches(ad.getUserPassword(), opt.getUserPassword()))) {
				return "Valid";
			} else {
				throw new InvalidCredentialsException();
			}
		} else {
			throw new AdminDoesNotExistException();
		}

	}

	
	@Override
	public String deleteAdmin(long id) throws AdminDoesNotExistException {
		if (adminrepo.existsById(id)) {
			adminrepo.deleteById(id);
			return "Deleted Successfully";
		}
		throw new AdminDoesNotExistException();
	}

	@Override
	public AdminDto updateAdminById(AdminDto adddto) throws AdminDoesNotExistException {
		Optional<Admin> op = adminrepo.findById(adddto.getAdminId());

		if (op.isEmpty()) {

			throw new AdminDoesNotExistException();

		}

		Admin c = mapper.map(adddto, Admin.class);

		return mapper.map(adminrepo.save(c), AdminDto.class);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		
		ResponseEntity<List<CustomerDto>> customer=CustomerAccess.viewAllCustomer();

		return customer.getBody();
	}
	
	@Override
	public List<BillDto> getAllBills() {
		ResponseEntity<List<BillDto>> bill=BillAccess.viewAllBill();
		return bill.getBody();
	}

	@Override
	public List<AdminDto> getAllAdmins() {
		List<Admin> adminList = adminrepo.findAll();
		return adminList.stream()
		.map(admin -> mapper.map(admin, AdminDto.class))
		.toList();	
		
	}


	

}
