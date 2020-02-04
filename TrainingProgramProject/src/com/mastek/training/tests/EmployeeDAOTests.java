package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.dao.DataAccessObject;
import com.mastek.training.hrapp.dao.EmployeeBinaryFileDAO;
import com.mastek.training.hrapp.dao.EmployeeJDBCDAO;
import com.mastek.training.hrapp.dao.EmployeeJSONFileDAO;
import com.mastek.training.hrapp.dao.EmployeeMongoDAO;

class EmployeeDAOTests {
	
	DataAccessObject<Employee> empDAO;

	@BeforeEach
	void setUp() throws Exception {
		//empDAO = new EmployeeBinaryFileDAO("empdata.dat");
		//empDAO = new EmployeeJSONFileDAO("empdata.json");
		//empDAO = new EmployeeJDBCDAO();
		empDAO = new EmployeeMongoDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEmployeeData() {
		Employee newEmp = new Employee();
		newEmp.setEmpno(32121);
		newEmp.setName("Example");
		newEmp.setDesignation(Designations.ARCHITECT);
		newEmp.setGrade(Grades.G10);
		newEmp.setUnitDaySalary(233);
		
//		String jsonOBJ = Employee.getJSONString(newEmp);
//		System.out.println(jsonOBJ);
//		Employee exemp = Employee.parseJSONString(jsonOBJ);
//		System.out.println(exemp);
		
		newEmp = empDAO.add(newEmp); //returns the object if saved successfully
		assertNotNull(newEmp,"Employee not Added");
		
		Employee fetchEmp = empDAO.find(32121);
		assertNotNull(fetchEmp,"Employee not Found");
	}
	
	@Test
	void testListAllEmployees() {
		Collection<Employee> emps = empDAO.listAll();
		for(Employee employee:emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	void testRemoveEmployee() {
		Employee newEmp = new Employee();
		newEmp.setEmpno(9999);
		newEmp.setName("Remove Example");
		newEmp.setDesignation(Designations.ARCHITECT);
		newEmp.setGrade(Grades.G10);
		newEmp.setUnitDaySalary(233);
		
		newEmp = empDAO.add(newEmp); //returns the object if saved successfully
		assertNotNull(newEmp,"Employee not Added");
		
		Employee removedEmp = empDAO.remove(9999);
		assertNotNull(removedEmp,"Employee not Removed");
		
		Employee checkRemovedEmp = empDAO.find(9999);
		assertNull(checkRemovedEmp,"Employee not Removed");
		
	}

}
