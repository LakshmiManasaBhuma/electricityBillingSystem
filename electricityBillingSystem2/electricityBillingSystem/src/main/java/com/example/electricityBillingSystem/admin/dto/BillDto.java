package com.example.electricityBillingSystem.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {
	
	private Long BillID;

	private Long CustomerID;

	private Date billingDate;

	private Date dueDate;

	private String billStatement;

	private float totalAmount;
}
