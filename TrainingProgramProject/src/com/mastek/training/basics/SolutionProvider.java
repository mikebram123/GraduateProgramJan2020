package com.mastek.training.basics;
//import java.util.Scanner;


public class SolutionProvider {
	
	/*
	 * take two numbers from user and display the maximum number as output
	 */
	//public static<return-data type> <name>(<param_type1><param_name1>,...)
	public static int getMaxNumber(int num1,int num2) {
		int max;
		if(num1>num2) {
			max = num1;
		}
		else{
			max = num2;
		}
		return max; //return the result to the caller
	}
	
	public static void quotientRemainder(int num1,int num2) {
		int quotient;
		int remainder;
		quotient = num1/num2;
		remainder = num1%num2;
        System.out.println("The Quotient is = " + quotient); 
        System.out.println("The Remainder is = " + remainder);
	}
	
	public static double kilosToMiles(double num1) {
		double miles;
		miles = 0.62*num1;
		return miles;
	}
	
	public static int calculateArea(int w, int h) {
		int area;
		area = w*h;
		return area;
	}
	
	public static double timeTaken(double averageSpeedMPH, double distanceMiles) {
		double time;
		time = distanceMiles/averageSpeedMPH;
		return time;
	}
	
	public static double circleArea(double r) {
		double area;
		area = 3.1416*r*r;
		return area;
	}
	
	public static void multiplicationTable(int num1) {
		for(int i=1;i<11;i++) {
			System.out.println(i*num1);
		}	
	}
	
	public static int minNumber(int num1, int num2, int num3) {
		int min;
		min = Math.min(num1, num2);
		min = Math.min(num3, min);
		return min;	
	}
	
	public static String studentDetails(int StudentID, String StudentName, int StudentAge, int Marks1, int Marks2,int Marks3) {
		double avg1;
		double avg2;
		double avg3;
		double finalavg;
		avg1 = Marks1/100;
		avg2 = Marks2/100;
		avg3=Marks3/100;
		finalavg= (avg1+avg2+avg3)/3;
		if(finalavg>0.5) {
			return "pass";
		}
		else {
			return "fail";
		}
	}
		
	public static String averageScore(int marks1, int marks2, int marks3) {
			int finalmark;
			finalmark= (marks1+marks2+marks3)/3;
			if(finalmark>90) {
				return "A+";
			}
			else if(finalmark<90 && finalmark>80) {
				return "A";
			}
			else if(finalmark<80 && finalmark>70) {
				return "A-";
			}
			else if(finalmark<70 && finalmark>60) {
				return "B";
			}
			else if(finalmark<60 && finalmark>50) {
				return "B-";
			}
			else{
				return "fail";
			}
		}
		
	static int finalSum=0;
		
	public static int getLucky(int num) {
	        sumOfDigits(num);
	        while(finalSum>9) {
	        	sumOfDigits(finalSum);
	        }
	        return finalSum;
		}

	public static int sumOfDigits(int num) {
			int sum=0;
	        while (num > 0) {
	            sum = sum + num % 10;
	            num = num / 10;
	        }
	        finalSum=sum;
	        return finalSum;
		}
	}


	

