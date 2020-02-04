package com.mastek.training.myshop;

import java.util.LinkedList;
import java.util.List;

public class ListShoppingCart implements ShoppingCart<Item> {

	List<Item> items;
	
	public ListShoppingCart() {
		items = new LinkedList<Item>();
	}
	
	@Override
	public int addItem(Item i) {
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		System.out.println("Index Of Item to be removed: "+items.indexOf(i));
		items.remove(i);  	// uses equals method of the item class [equals and hash code]
		return items.size();
	}

	@Override
	public void printItems() {
		System.out.println("Items in Cart");
		for (Item item : items) {
			System.out.println(item);
		}

	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
