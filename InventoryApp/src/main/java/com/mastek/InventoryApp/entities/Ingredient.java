package com.mastek.InventoryApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // declared the class as entity, to be managed by JPA
@Table(name="JPA_Ingredients") //declare the table name associated with this class
public class Ingredient {

	private int ingredientId;
	private String name;
	
	Set<Product> products = new HashSet<>();
	
	
	@ManyToMany(mappedBy="ingredientAssigned")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Ingredient() {
	}

	@Id //marking the property as primary key for the table
	@Column(name="ingredient_id")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public int getIngredientId() {
		return ingredientId;
	}



	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
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
		Ingredient other = (Ingredient) obj;
		if (ingredientId != other.ingredientId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", name=" + name + "]";
	}
	
	
	
	
}
