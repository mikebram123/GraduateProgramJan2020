package com.mastek.BankApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Account") //declare the table name associated with this class
public class Account {

	private int accountId;
	private long sortCode;
	private String bankName;
	
	private Set<Customer> customerAssigned = new HashSet<>();
	private Set<Transaction> TransactionHistory = new HashSet<>();
	
	
	@OneToMany(mappedBy="LinkedAccount", cascade=CascadeType.ALL)
	public Set<Transaction> getTransactionHistory() {
		return TransactionHistory;
	}

	public void setTransactionHistory(Set<Transaction> transactionHistory) {
		TransactionHistory = transactionHistory;
	}

	@ManyToMany(mappedBy="accountAssigned")
	public Set<Customer> getCustomerAssigned() {
		return customerAssigned;
	}

	public void setCustomerAssigned(Set<Customer> customerAssigned) {
		this.customerAssigned = customerAssigned;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public long getSortCode() {
		return sortCode;
	}

	public void setSortCode(long sortCode) {
		this.sortCode = sortCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", sortCode=" + sortCode + ", bankName=" + bankName + "]";
	}
	
	
	
}
