package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class AnotherClass {
	public static void main(String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//In the another class of other package we call access public members of the class
		System.out.println(//"Private " + sc1.privateNumber + 
				//" Default " + sc1.defaultNumber+
				//" Protected "+ sc1.protectedNumber+ 
				" Public "+sc1.publicNumber);
	}
}
