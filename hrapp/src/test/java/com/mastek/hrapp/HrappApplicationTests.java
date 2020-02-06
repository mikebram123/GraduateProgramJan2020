package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest
class HrappApplicationTests {

	@Autowired //spring will provide the object using IOC, dependency Injection technique
	EmployeeService empSvc;
	
	@Autowired
	EmployeeService empSvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired 
	DepartmentJPADAO depDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	@Test
	void testEmployeeServiceExampleMethod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
	}
	
	//@Test
	void testEmployeeDAOadd() {
		Employee emp = new Employee();
		emp.setName("New Emp");
		emp.setSalary(1234);
		emp.setDesignation(Designation.MANAGER);
		
		emp = empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull(emp,"Employee Not Added");
	}
	
	@Test
	void testListEmployees() {
		Iterable<Employee> emps = empDAO.findAll();
		assertNotNull(emps,"Employees not Found");
		for(Employee employee:emps) {
			System.out.println(employee);
		}
	}
	//@Test
	void testDepartmentDAOadd() {
		Department dep = new Department();
		
		dep.setName("Example");
		dep.setLocation("Leeds");

		dep = depDAO.save(dep);
		
		System.out.println(dep);
		assertNotNull(dep,"Departement Not Added");
	}
	@Test
	void testListDepartment() {
		Iterable<Department> deps = depDAO.findAll();
		assertNotNull(deps,"Department not Found");
		for(Department department :deps) {
			System.out.println(department);
		}
	}
	//@Test
	void testProjectDAOadd() {
		Project pro = new Project();
		
		pro.setCustomerName("Example Project");
		pro.setName("Example Project");

		pro = projectDAO.save(pro);
		
		System.out.println(pro);
		assertNotNull(pro,"Project Not Added");
	}
	@Test
	void testListProject() {
		Iterable<Project> pros = projectDAO.findAll();
		assertNotNull(pros,"Department not Found");
		for(Project pro :pros) {
			System.out.println(pro);
		}
	}
	@Test
	void testUpdateEmployees() {
		Employee emp = empDAO.findById(1).get();
		System.out.println("Employee Fetched: "+emp);
		
		emp.setSalary(emp.getSalary()+1001);
		emp.setDesignation(Designation.TESTER);
		
		emp = empDAO.save(emp);
		
		System.out.println("Updated Employee:"+emp);
	}
	
	//@Test
	void testDeleteEmployeeById() {
		//empDAO.delete(emp); deletes by object
		empDAO.deleteById(5); //deletes by id
		
	}
	@Test
	void testAssignEmployeeToDepartment() {
		//empSVC.assignEmployeeToDepartment(empno, deptno)
		Employee emp = empSvc.assignEmployeeToDepartment(4,18);
		assertNotNull(emp.getCurrentDepartment(),"Department not Assigned");
	}
	
	@Test
	void testAssignEmployeeToProject() {
		Employee emp = empSvc.assignEmployeeToProject(14,19);
		assertTrue(emp.getProjectAssigned().size()>0,"Projects Assigned");
	}

}
