package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncement;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.packone.Circle;
import com.mastek.training.packone.Rectangle;
import com.mastek.training.packone.Shape;


class HRApplicationTests {
	
	Employee ex1;
	
	@BeforeEach
	public void setupEmpTestCases() {
		System.out.println("Before Test Case");
		ex1 = new Employee();
		ex1.setEmpno(32000);
		ex1.setName("Example");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);
		
		//Employee ex2 = new Employee(10000);
		//Employee ex3 = new Employee(1001,"Example",100.0,Designations.DEVELOPER);
		
		//ex2=null; //release the object to mark as object
		//ex3=null;
		System.gc();//notify system to collect garbage
		//ex2.getEmpno();//will throw NullPointerException
	}
	
	@AfterEach
	public void tearDownEmpTestCases() {
		System.out.println("After Test Case");
		
	}

	@Test
	void testCreateAndPrintExampleEmployeeObject() {
		System.out.println("Test Case Create");
//		Employee ex1 = new Employee();
//		ex1.setEmpno(32000);
//		ex1.setName("Example");
//		ex1.setUnitDaySalary(3000);
//		ex1.setDesignation(Designations.MANAGER);
//		ex1.setGrade(Grades.G8);
		
		System.out.println(
				"Number: " +ex1.getEmpno()+
				" Name: "+ex1.getName()+
				" Day Salary: "+ex1.getUnitDaySalary()+
				" Designation: "+ex1.getDesignation()+
				" Grade: "+ex1.getGrade());
	}
	@Test
	void testComputeSalaryEmployeeObject() {
//		System.out.println("Test Case Compute");
//		Employee ex1 = new Employee();
//		ex1.setEmpno(32000);
//		ex1.setName("Example");
//		ex1.setUnitDaySalary(300);
//		ex1.setDesignation(Designations.MANAGER);
//		ex1.setGrade(Grades.G8);
		
		try {
			assertEquals(0,ex1.getNetSalary(-30), "Invalid Net Salary Computation");
			assertEquals(9000,ex1.getNetSalary(30), "Invalid Net Salary Computation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testSalesEmployeeObjectUsage() {
		SalesEmployee saleEx1 = new SalesEmployee();
		
		saleEx1.setEmpno(111);
		saleEx1.setName("Example");
		saleEx1.setUnitDaySalary(100);
		saleEx1.setDesignation(Designations.ARCHITECT);
		saleEx1.setGrade(Grades.G10);
		saleEx1.setCommission(0.8);
		saleEx1.setTarget(1000000000);
		
		try {
			assertEquals(1620, saleEx1.getNetSalary(9), "Fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void testObjectFeaturesOnEmployee() {
		System.out.println("<=======Object Fetures Start=========>");
		System.out.println(ex1.toString());
		System.out.println("HashCode: "+ex1.hashCode());
		System.out.println("<=======Object Fetures End=========>");
	}
	
	@Test
	void testSendAnnouncementToEmployees() {
		//we cannot instantiate abstract class using new keyword
		//Announcement exAnnouncement = new Announcement();
		
		//to use an abstract class object you must extends it with derived class
		//and override all abstract methods defined in base/parent class
		Announcement exSMS = new SMSAnnouncement();
		exSMS.setFrom("HR");
		exSMS.setForGroup("MASKETEERS AT GLASGOW");
		exSMS.setSubject("Weather Conditions");
		exSMS.setContentText("All employees are advised to opt for work from home, tomorrow");
		
		Announcement exEmail = new EmailAnnouncement();
		exEmail.setFrom("Leadership Team");
		exEmail.setForGroup("MASKETEERS");
		exEmail.setSubject("QMeet");
		exEmail.setContentText("Invitiation to attend QMeet");
		
		if(exSMS instanceof SMSAnnouncement) {
			System.out.println("Connect to telecom SMS Service");
			exSMS.sendAnnouncement(); //connect to SMS and use send from SMSAnnouncement

		}
		if(exEmail instanceof EmailAnnouncement) {
			System.out.println("Connect to email Service");
			exEmail.sendAnnouncement();//connect to Email and use send from EmailAnnouncement
		}

		
		assertTrue(exSMS instanceof SMSAnnouncement, "Invalid Announcement Implementation");
		assertTrue(exEmail instanceof EmailAnnouncement, "Invalid Announcement Implementation");
	}
	
	@Test
	void testShapeExample() {
		Rectangle rect = new Rectangle();
		rect.setLength(10);
		rect.setBreadth(20);
		
		Circle circle = new Circle();
		circle.setRadius(10);
		
		Shape shRect = rect;
		Shape shCircle = circle;
		
		System.out.println("Rectangle Area "+shRect.getArea());
		System.out.println("Rectangle Perimeter " +shRect.getPerimeter());
		
		System.out.println("Circle Area "+shCircle.getArea());
		System.out.println("Circle Perimeter "+shCircle.getPerimeter());
		
		assertTrue(rect instanceof Shape,"Invalid Type of Shape");
		assertTrue(circle instanceof Shape, "Invalid Type of Shape");
	}

}
