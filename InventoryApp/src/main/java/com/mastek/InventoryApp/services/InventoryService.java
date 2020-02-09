package com.mastek.InventoryApp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.InventoryApp.dao.CategoryJPADAO;
import com.mastek.InventoryApp.dao.CustomerJPADAO;
import com.mastek.InventoryApp.dao.IngredientJPADAO;
import com.mastek.InventoryApp.dao.OrderJPADAO;
import com.mastek.InventoryApp.dao.ProductJPADAO;
import com.mastek.InventoryApp.entities.Category;
import com.mastek.InventoryApp.entities.Customer;
import com.mastek.InventoryApp.entities.Ingredient;
import com.mastek.InventoryApp.entities.Order;
import com.mastek.InventoryApp.entities.Product;

@Component //marking the class as bean to be created
@Scope("singleton") //singleton:one object used across test cases, prototype: one object per request
public class InventoryService {
	
	String exampleProperty;
	
	@Autowired
	CategoryJPADAO catDAO;
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	IngredientJPADAO ingDAO;
	
	@Autowired
	OrderJPADAO ordDAO;
	
	@Autowired
	ProductJPADAO proDAO;
	
	public InventoryService() {
		System.out.println("Inventory Service Created");
	}
	
	@PostConstruct //Initialisation method of the class
	public void initializeService() {
		System.out.println("Employee Service Initialized");
	}
	
	@PreDestroy //calls before the shutting down the application
	public void terminateService() {
		System.out.println("Employee Service Terminated");
	}
	
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	}
	
	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("Spring Example Data Source") //Initialise the property with the simple value
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example Property Set :"+exampleProperty);
		this.exampleProperty = exampleProperty;
	}
	
	@Transactional
	public Order assignOrderToCustomer(int orderId, int custId) {
		Customer cus = cusDAO.findById(custId).get();
		Order ord = ordDAO.findById(orderId).get();
		
		ord.setCurrentCustomer(cus);
		cus.getTeam().add(ord);
		
		ordDAO.save(ord);
		cusDAO.save(cus);
		
		return ord;
	}
	
	@Transactional
	public Order assignOrderToCategory(int orderId, int catId) {
		Category cat = catDAO.findById(catId).get();
		Order ord = ordDAO.findById(orderId).get();
		
		ord.setCurrentCategory(cat);
		cat.getOrders().add(ord);
		
		ordDAO.save(ord);
		catDAO.save(cat);
		
		return ord;
	}
	
	@Transactional
	public Product assignProductToOrder(int prodId, int ordId) {
		Product pro = proDAO.findById(prodId).get();
		Order newOrder = ordDAO.findById(ordId).get();
		
		pro.getOrderAssigned().add(newOrder);
		proDAO.save(pro);
		
		return pro;	
	}
	
	@Transactional
	public Product assignProductToIngredient(int prodId, int ingId) {
		Product pro = proDAO.findById(prodId).get();
		Ingredient newIng = ingDAO.findById(ingId).get();
		
		pro.getIngredientAssigned().add(newIng);
		proDAO.save(pro);
		
		return pro;
	}
}
