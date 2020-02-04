package com.mastek.training.packone;

import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) {
		int num1, num2, result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Num 1: ");
			num1 = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Num 2: ");
			num2 = Integer.parseInt(sc.nextLine());
			result = num1/num2;
			System.out.println("Division is: "+result);
		} catch (NumberFormatException e) {
			e.printStackTrace(); //print the exception information on the console
			System.err.println("Invalid Number Entered");
		}
		catch(Exception ex) {//handles all types of exceptions
			System.err.println("Exception Occured: " + ex);//print the exception with messages
			System.err.println("Exception Message"+ex.getMessage());//print the message
			ex.printStackTrace();//print the complete information about exception
		}
		finally {//block will be executed in all the scenarios of success or failure of application
			//in case the exception not handled, it will abort the application after the finally block
			System.out.println("Scanner Closed");
			sc.close();
		}
		System.out.println("Program Completed");
	
	}
}
