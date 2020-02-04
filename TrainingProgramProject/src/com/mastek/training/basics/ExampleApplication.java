package com.mastek.training.basics;

public class ExampleApplication {
	
	public static void main(String[] args) {
		/*
		int maxResult=0;
		maxResult = SolutionProvider.getMaxNumber(10, 2);
		System.out.println("Max Result is: " + maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(10, 10);
		System.out.println("Max Result is: " + maxResult);

		maxResult = SolutionProvider.getMaxNumber(-1, 2);
		System.out.println("Max Result is: " + maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(999999, 2);
		System.out.println("Max Result is: " + maxResult);
		*/
		
		//SolutionProvider.multiplicationTable(2);
		//System.out.println(SolutionProvider.getLucky(12345678));
		
		int i =0;
		while(true) {
			System.out.println("a" + i);
			if(i++==4) {
				System.out.println("njsnse"+ i);
				//i++;
				System.out.println("b" + i);
				break;
			}
			System.out.println("c"+i);
			++i;
			System.out.println("d"+i);
		}
		System.out.println("i="+(i++));
	}
		
		
}
