package com.mastek.BankApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.BankApp.dao.AccountJPADAO;
import com.mastek.BankApp.dao.CustomerJPADAO;
import com.mastek.BankApp.dao.TransactionJPADAO;
import com.mastek.BankApp.entities.Account;
import com.mastek.BankApp.entities.Customer;
import com.mastek.BankApp.entities.Transaction;
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
	
	
	//@Test
	void testAddCustomer() {
		Customer cus = new Customer();
		cus.setName("Customer Example");
		cus.setAddress("Address Example");
		
		cus = cusDAO.save(cus);
		
		assertNotNull(cus, "Cus not Added");
	}
	
	//@Test
	void testAddAccount() {
		Account acc = new Account();
		acc.setBankName("RBS");
		acc.setSortCode(1629l);
		
		acc = accDAO.save(acc);
	}
	
	//@Test
	void testAddTransaction() {
		Transaction tra = new Transaction();
		tra.setPaymentType("Visa");
		tra.setAmount(50.00);
		
		tra =traDAO.save(tra);
	}
	
	//@Test
	void testAssignCustomerToAccount() {
		Customer cus = banDAO.assignCustomerToAccount(1, 2);	
	}
	

	@Test
	void testAssignTransactionToAccount() {
		Transaction tra = banDAO.assignTransactionToAccount(3, 2);
	}

}
