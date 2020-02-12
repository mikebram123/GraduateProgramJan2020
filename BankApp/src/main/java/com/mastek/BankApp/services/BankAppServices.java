package com.mastek.BankApp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.BankApp.dao.AccountJPADAO;
import com.mastek.BankApp.dao.CustomerJPADAO;
import com.mastek.BankApp.dao.TransactionJPADAO;
import com.mastek.BankApp.dao.TransferRequestsJPADAO;
import com.mastek.BankApp.entities.Account;
import com.mastek.BankApp.entities.Customer;
import com.mastek.BankApp.entities.Transaction;
import com.mastek.BankApp.entities.TransferRequests;

@Component //marking the class as bean to be created
@Scope("singleton") //singleton:one object used across test cases, prototype: one object per request
public class BankAppServices {
	
	@Autowired
	AccountJPADAO accDAO;
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	TransactionJPADAO traDAO;
	
	@Autowired
	TransferRequestsJPADAO trDAO;
	
	public BankAppServices() {
	}
	
	@PostConstruct //Initialisation method of the class
	public void initializeService() {
		System.out.println("Service Initialized");
	}
	
	@PreDestroy //calls before the shutting down the application
	public void terminateService() {
		System.out.println("Service Terminated");
	}
	
	@Transactional
	public Customer assignCustomerToAccount(int cusId, int accId) {
		Customer cus = cusDAO.findById(cusId).get();
		Account acc = accDAO.findById(accId).get();
		
		cus.getAccountAssigned().add(acc);
		cus = cusDAO.save(cus);
		return cus;
		
	}
	
	@Transactional
	public Transaction assignTransactionToAccount(int traId, int accId) {
		Transaction tra = traDAO.findById(traId).get();
		Account acc = accDAO.findById(accId).get();
		
		tra.setLinkedAccount(acc);
		acc.getTransactionHistory().add(tra);
		
		traDAO.save(tra);
		accDAO.save(acc);
		
		return tra;
	}
	
	@Transactional
	public TransferRequests assignTRtoTransaction(int transferRequestId, int transactionId) {
		TransferRequests tr = trDAO.findById(transferRequestId).get();
		Transaction tra = traDAO.findById(transactionId).get();
		
		tr.getTr().add(tra);
		
		tr = trDAO.save(tr);
		
		return tr;
	}
	

}
