package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class DerivedClass extends SimpleClass {
	public static void main(String[] args) {
		DerivedClass sc1 = new DerivedClass();
		//In the derived class of the same package can access all members apart from private
		System.out.println(//"Private " + sc1.privateNumber + 
				//" Default " + sc1.defaultNumber+
				" Protected "+ sc1.protectedNumber+ 
				" Public "+sc1.publicNumber);
	}
}
