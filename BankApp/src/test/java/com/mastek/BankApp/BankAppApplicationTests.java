package com.mastek.BankApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.BankApp.dao.AccountJPADAO;
import com.mastek.BankApp.dao.CustomerJPADAO;
import com.mastek.BankApp.dao.LoanJPADAO;
import com.mastek.BankApp.dao.TransactionJPADAO;
import com.mastek.BankApp.dao.TransferRequestsJPADAO;
import com.mastek.BankApp.entities.Account;
import com.mastek.BankApp.entities.CarLoan;
import com.mastek.BankApp.entities.Customer;
import com.mastek.BankApp.entities.HomeLoan;
import com.mastek.BankApp.entities.Loan;
import com.mastek.BankApp.entities.Transaction;
import com.mastek.BankApp.entities.TransferRequests;
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
	
	@Autowired
	LoanJPADAO loaDAO;
	
	@Autowired
	TransferRequestsJPADAO trDAO;
	
	
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
	

	//@Test
	void testAssignTransactionToAccount() {
		Transaction tra = banDAO.assignTransactionToAccount(3, 2);
	}
	
	//@Test
	void testLoanAdd() {
		Loan loa = new Loan();
		loa.setLoanAmount(200);
		
		loa = loaDAO.save(loa);
		
		assertNotNull(loa, "FAILED");
	}
	
	//@Test
	void testCarLoanAdd() {
		CarLoan car = new CarLoan();
		car.setCarLoanProvider("Example");
		car.setLoanAmount(300);
		car.setCarLoanId(1);
		
		car = loaDAO.save(car);
		
		assertNotNull(car,"FAILED");
	}
	
	//@Test
	void testHomeLoanAdd() {
		HomeLoan hom = new HomeLoan();
		hom.setLoanAmount(400);
		hom.setProvider("Example");
		hom.setHomeLoanId(2);
		
		hom=loaDAO.save(hom);
		
		assertNotNull(hom,"FAILED");
	}
	
	//@Test
	void testAddTransferRequestsDocument() {
		TransferRequests tr = new TransferRequests();
		tr.setAmount(500);
		tr.setTransferRequestsId(7);
		tr.setFromAccount("FROM");
		tr.setToAccount("TO");
		tr.setDescription("DESCRIPTION");
		
		tr = trDAO.save(tr);
		
		
	}
	
	@Test
	void testApplyForTransferRequest() {
		int trId = 5;
		int traId = 3;
		
		TransferRequests tr = banDAO.assignTRtoTransaction(7, 3);
		for (Transaction t : tr.getTr()) {
			System.out.println(t);
		}
	}

}
