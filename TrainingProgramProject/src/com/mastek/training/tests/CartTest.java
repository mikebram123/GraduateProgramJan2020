package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.shopping.ShoppingCart;

class CartTest {
	ShoppingCart c1;
	
	@BeforeEach
	public void setupCartTestCases() {
		c1 = new ShoppingCart();
	}
	
	@AfterEach
	public void tearDownCartTestCases() {
		
	}
	@Test
	void addToCartTest() {
		c1.addToCart("Apple", 0.50, 5);
		assertEquals(3.0, c1.getTotalPriceOfCart());
		System.out.println(c1.toString());	
	}
	@Test
	void addMultipleItemsWithVoucherTest() {
		c1.addToCart("Apple", 0.50, 5);
		c1.addToCart("Cherries", 1.75, 10);
		c1.addToCart("Tomatoes", 1.0, 100);
		c1.addToCart("Rice", 0.60, 5);
		c1.addToCart("Noodles", 1.25, 5);
		c1.addToCart("Salad", 1.20, 2);
		c1.applyVoucherCode("Black");
		assertEquals(78.99, c1.getTotalPriceOfCart());
		System.out.println(c1.toString());
	}
	

}
