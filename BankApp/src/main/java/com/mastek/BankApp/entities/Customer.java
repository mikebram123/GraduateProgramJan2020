package com.mastek.BankApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Customer") //declare the table name associated with this class
public class Customer {

	private int customerId;
	private String name;
	private String address;
	
	private Set<Account> accountAssigned = new HashSet<>();
	

	@ManyToMany(cascade=CascadeType.ALL) // configure many to many associations for entities
	@JoinTable(name="JPA_ACCOUNT_ASSIGNMENTS", //provide the join table name
			joinColumns= {@JoinColumn(name="fk_cusId")}, //foreign key column for current class
			inverseJoinColumns = {@JoinColumn(name="fk_accountId")} //foreign key column for collection
			)
	public Set<Account> getAccountAssigned() {
		return accountAssigned;
	}

	public void setAccountAssigned(Set<Account> accountAssigned) {
		this.accountAssigned = accountAssigned;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
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
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}
	
}
