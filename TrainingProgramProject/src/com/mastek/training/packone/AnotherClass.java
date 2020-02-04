package com.mastek.training.packone;

public class AnotherClass {
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//In the another class we call access all types of members of the class except private members
		System.out.println(//"Private " + sc1.privateNumber + 
				" Default " + sc1.defaultNumber+
				" Protected "+ sc1.protectedNumber+ 
				" Public "+sc1.publicNumber);
	}
}
