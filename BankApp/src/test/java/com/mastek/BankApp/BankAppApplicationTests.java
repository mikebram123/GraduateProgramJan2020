package com.mastek.BankApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.BankApp.dao.AccountJPADAO;
import com.mastek.BankApp.dao.CustomerJPADAO;
import com.mastek.BankApp.dao.TransactionJPADAO;
import com.mastek.BankApp.entities.Customer;
import com.mastek.BankApp.services.BankAppServices;

@SpringBootTest
class BankAppApplicationTests {

	@Autowired
	BankAppServices banDAO;
	
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	TransactionJPADAO traDAO;
	
	
	@Test
	void testAddCustomer() {
		Customer cus = new Customer();
		cus.setName("Customer Example");
		cus.setAddress("Address Example");
		
		cus = cusDAO.save(cus);
		
		assertNotNull(cus, "Cus not Added");
	}
	
	//@Test
	void testAddAccount() {
		
	}
	

}
