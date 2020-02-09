package com.mastek.InventoryApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Products") //declare the table name associated with this class
public class Product {

	private int productId;
	private String productName;
	private double unitPrice;
	
	Set<Order> orderAssigned = new HashSet<>();
	Set<Ingredient> ingredientAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_INGREDIENT_ASSIGNMENTS",
			joinColumns= {@JoinColumn(name="fk_productId")}, 
			inverseJoinColumns = {@JoinColumn(name="fk_ingredientId")}
			)
	public Set<Ingredient> getIngredientAssigned() {
		return ingredientAssigned;
	}

	public void setIngredientAssigned(Set<Ingredient> ingredientAssigned) {
		this.ingredientAssigned = ingredientAssigned;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_ORDER_ASSIGNMENTS",
			joinColumns= {@JoinColumn(name="fk_productId")}, 
			inverseJoinColumns = {@JoinColumn(name="fk_orderId")}
			)
	public Set<Order> getOrderAssigned() {
		return orderAssigned;
	}

	public void setOrderAssigned(Set<Order> orderAssigned) {
		this.orderAssigned = orderAssigned;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Id //marking the property as primary key for the table
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice + "]";
	}
	
	
}
