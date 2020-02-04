package com.mastek.training.shopping;

public class Item {
	
	private String itemName;
	private int numberPurchased;
	private double itemPrice;

	public static final int MAX_QUANTITY = 10;
	public static final int DEFAULT_ZERO = 0;
	
	{
		itemName = "Apple";
		numberPurchased=5;
		itemPrice=0.50;
	}
	
	public Item(String name, double price, int quantity) {
	      name = itemName;
	      price = itemPrice;
	      quantity = numberPurchased;
	}
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getNumberPurchased() {
		return numberPurchased;
	}
	public void setNumberPurchased(int numberPurchased) {
		this.numberPurchased = numberPurchased;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
}
