package com.mastek.training.shopping;

import java.util.Arrays;

public class ShoppingCart {
    private Item[] cart;
    private int itemCount;   
    private double totalPriceOfCart;  
    private int capacity;   
    
    
    public static final double TAX = 1.2;
    public static String VOUCHER = "Black";
    

    public ShoppingCart()
    {
      capacity = 5;
      cart = new Item[capacity];
      itemCount = 0;
      totalPriceOfCart = 0.0;
    }
    public void addToCart(String itemName, double price, int quantity)
    { 

        Item temp = new Item(itemName, price, quantity);
        totalPriceOfCart += (price * quantity * TAX);
        cart[itemCount] = temp;
        itemCount += 1;
        if(itemCount==capacity)
        {
            increaseSize();
        }
    }
    
    
    private void increaseSize()
    {
        Item[] temp = new Item[capacity+3];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = cart[i];
        }
        cart = temp; 
        temp = null;
        capacity = cart.length;
    }
	public double getTotalPriceOfCart() {
		return totalPriceOfCart;
	}
	public void setTotalPriceOfCart(double totalPriceOfCart) {
		this.totalPriceOfCart = totalPriceOfCart;
	}
	
	public void applyVoucherCode(String voucher) {
		if(voucher == VOUCHER) {
			setTotalPriceOfCart(totalPriceOfCart/2);
		}
		else{
			setTotalPriceOfCart(totalPriceOfCart);
		};
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [cart=" + Arrays.toString(cart) + ", itemCount=" + itemCount + ", totalPriceOfCart="
				+ totalPriceOfCart + ", capacity=" + capacity + "]";
	}
	
	
    
    
}

