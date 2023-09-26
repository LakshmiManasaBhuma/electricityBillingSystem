package com.example.electricityBillingSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.electricityBillingSystem.admin.dto.AdminDto;
import com.example.electricityBillingSystem.admin.entity.Admin;
import com.example.electricityBillingSystem.admin.exception.AdminAlreadyExistsException;
import com.example.electricityBillingSystem.admin.repository.AdminRepo;
import com.example.electricityBillingSystem.admin.service.AdminServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest {
	
	@Mock
	private AdminRepo adminrepo;
	
	@Mock
	private ModelMapper mapper;
	
	@Mock
	private PasswordEncoder passwordencoder;
	
	@InjectMocks
	private AdminServiceImpl adminservimpl;
	
	
	@Test
	public void testAddAdmin() throws AdminAlreadyExistsException {
		
		AdminDto input = new AdminDto();
        input.setAdminId(76748L);
        input.setUserName("admin");
        input.setUserPassword("chinnu@143");
        Admin mappedCustomer = new Admin();
        Admin savedCustomer = new Admin();
        
        
        when(mapper.map(input, Admin.class)).thenReturn(mappedCustomer);
        
        when(adminrepo.save(mappedCustomer)).thenReturn(savedCustomer);
        
        when(mapper.map(savedCustomer, AdminDto.class)).thenReturn(input);
        
        AdminDto result = adminservimpl.insertAdmin(input);
        
        assertEquals(input,result);
	}
	
	
	
	
	
	

}
