package com.mastek.InventoryApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
import com.mastek.InventoryApp.services.InventoryService;


@SpringBootTest
class InventoryAppApplicationTests {

	@Autowired //spring will provide the object using IOC, dependency Injection technique
	InventoryService invSvc;
	
	@Autowired
	InventoryService invSvc1;
	
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
	
	//@Test
	void testEmployeeServiceExampleMethod() {
		invSvc.exampleMethod();
		invSvc1.exampleMethod();
	}
	
	//@Test
	void testCustomerDAOAdd() {
		Customer cus = new Customer();
		cus.setName("Customer Example");
		cus.setEmail("CustomerExample@mastek.com");
		
		cus = cusDAO.save(cus);
		System.out.println(cus);
		assertNotNull(cus,"Employee Not Added");
	}
	
	//@Test
	void testCategoryDAOAdd() {
		Category cat = new Category();
		cat.setCategoryName("Category Example");
		
		cat = catDAO.save(cat);
		System.out.println(cat);
		assertNotNull(cat, "Category Not Added");
	}
	
	//@Test
	void testIngredientDAOAdd() {
		Ingredient ing = new Ingredient();
		ing.setName("Ingredient Example");
		
		ing = ingDAO.save(ing);
		System.out.println(ing);
		assertNotNull(ing, "Ingredient Not Added");
	}
	
	//@Test
	void testOrderDAOAdd() {
		Order ord = new Order();
		ord.setPrice(1.89);
		
		ord= ordDAO.save(ord);
		System.out.println(ord);
		assertNotNull(ord, "Order Not Added");
	}
	
	//@Test
	void testProductDAOAdd() {
		Product pro = new Product();
		pro.setProductName("Product Example");
		pro.setUnitPrice(0.89);
		
		pro=proDAO.save(pro);
		System.out.println(pro);
		assertNotNull(pro, "Product not Added");	
	}
	
	//@Test
	void testAssignOrderToCustomer() {
		Order ord = invSvc.assignOrderToCustomer(20, 4);
		assertNotNull(ord.getCurrentCustomer(),"Customer not Assigned");
	}
	
	//@Test
	void testAssignOrderToCategory() {
		Order ord = invSvc.assignOrderToCategory(20, 10);
		assertNotNull(ord.getCurrentCategory(),"Category not Assigned");
	}
	
	//@Test
	void testAssignProductToIngredient() {
		Product pro = invSvc.assignProductToIngredient(23, 12);
		assertTrue(pro.getIngredientAssigned().size()>0,"Ingredients Assigned");
	}
	
	@Test
	void testAssignProductToOrder() {
		Product pro = invSvc.assignProductToOrder(21, 16);
		assertTrue(pro.getOrderAssigned().size()>0,"Order Assigned");
	}

}
