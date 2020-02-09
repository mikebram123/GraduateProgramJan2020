package com.mastek.InventoryApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Customers") //declare the table name associated with this class
public class Customer {

	private int custId;
	private String name;
	private String email;
	
	Set<Order> team = new HashSet<>();
	
	
	@OneToMany(mappedBy="currentCustomer", cascade=CascadeType.ALL)
	public Set<Order> getTeam() {
		return team;
	}

	public void setTeam(Set<Order> team) {
		this.team = team;
	}

	public Customer() {
	}
	
	@Id //marking the property as primary key for the table
	@GeneratedValue(strategy=GenerationType.AUTO) //auto numbering configuration as per DB
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
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
		if (custId != other.custId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", email=" + email + "]";
	}
	
	

	
	
	
	
}
