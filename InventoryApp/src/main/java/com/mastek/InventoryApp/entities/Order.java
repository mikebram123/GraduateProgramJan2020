package com.mastek.InventoryApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Orders") //declare the table name associated with this class
public class Order {
	
	private int orderId;
	private double price;
	
	Customer currentCustomer;
	Category currentCategory;
	
	Set<Product> productSet = new HashSet<>();
	
	public Order() {
	}
	
	@ManyToMany(mappedBy="orderAssigned")
	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	@ManyToOne
	@JoinColumn(name="fk_categoryId")
	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	@ManyToOne  
	@JoinColumn(name="fk_customer_Id") 
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	@Id //marking the property as primary key for the table
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.AUTO) //auto numbering configuration as per DB
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
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
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + "]";
	}
	

}
