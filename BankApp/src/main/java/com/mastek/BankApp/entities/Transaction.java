package com.mastek.BankApp.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Transaction") //declare the table name associated with this class
public class Transaction {

	private int transactionId;
	private double amount;
	private String paymentType;
	
	private Account LinkedAccount;
	
	@ManyToOne //One Employee is associated with one of the many departments 
	@JoinColumn(name="fk_account_id") //the foreign key Column to store the associate deptno
	public Account getLinkedAccount() {
		return LinkedAccount;
	}

	public void setLinkedAccount(Account linkedAccount) {
		LinkedAccount = linkedAccount;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transactionId;
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
		Transaction other = (Transaction) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", paymentType=" + paymentType
				+ "]";
	}
	
	
}
