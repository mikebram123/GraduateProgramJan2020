package com.mastek.training.packone;

public class SimpleClass {
	
	private int privateNumber=10;
	int defaultNumber = 10;
	protected int protectedNumber = 10;
	public int publicNumber = 10;
	
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//In the same class we can access all the types in the class
		System.out.println("Private " + sc1.privateNumber + " Default " + sc1.defaultNumber+
				" Protected "+ sc1.protectedNumber+ " Public "+sc1.publicNumber);
	}

}
