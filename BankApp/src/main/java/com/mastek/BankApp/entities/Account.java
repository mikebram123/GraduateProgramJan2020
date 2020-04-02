package com.mastek.BankApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Account") //declare the table name associated with this class
public class Account {

	private int accountId;
	
	@FormParam("sortCode")
	private long sortCode;
	
	@FormParam("bankName")
	private String bankName;
	
	Set<Customer> customerAssigned = new HashSet<>();
	Set<Transaction> TransactionHistory = new HashSet<>();
	
	
	@OneToMany(mappedBy="linkedAccount", cascade=CascadeType.ALL)
	@XmlTransient
	public Set<Transaction> getTransactionHistory() {
		return TransactionHistory;
	}

	public void setTransactionHistory(Set<Transaction> transactionHistory) {
		TransactionHistory = transactionHistory;
	}

	@ManyToMany(mappedBy="accountAssigned")
	@XmlTransient
	public Set<Customer> getCustomerAssigned() {
		return customerAssigned;
	}

	public void setCustomerAssigned(Set<Customer> customerAssigned) {
		this.customerAssigned = customerAssigned;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	@Id //marking the property as primary key for the table
	@GeneratedValue(strategy=GenerationType.AUTO) //auto numbering configuration as per DB
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
