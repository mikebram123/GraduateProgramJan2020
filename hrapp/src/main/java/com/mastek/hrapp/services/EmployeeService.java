package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;

@Component //marking the class as bean to be created
@Scope("singleton") //singleton:one object used across test cases, prototype: one object per request
public class EmployeeService {

	String exampleProperty;
	
	//declare all the entity DAOs to perform operation across multiple entities
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	@PostConstruct //Initialisation method of the class
	public void initializeService() {
		System.out.println("Employee Service Initialized");
	}
	
	@PreDestroy //calls before the shutting down the application
	public void terminateService() {
		System.out.println("Employee Service Terminated");
	}
	
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	}

	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("Spring Example Data Source") //Initialise the property with the simple value
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example Property Set :"+exampleProperty);
		this.exampleProperty = exampleProperty;
	}

	@Transactional //this will keep the session open until the method returns the value
	public Employee assignEmployeeToDepartment(int empno, int deptno) {
		Employee emp = empDAO.findById(empno).get(); //fetch the employee if exists
		Department dept = deptDAO.findById(deptno).get(); //fetch the department if exists
		
		//assign the association between employee and department
		emp.setCurrentDepartment(dept); //assign the department to employee
		dept.getTeam().add(emp); //add the employee in the department team
		
		//save changes in database
		empDAO.save(emp);
		deptDAO.save(dept);
		
		return emp; //return the result
	}

	@Transactional
	public Employee assignEmployeeToProject(int empno, int projectId) {
		Employee emp = empDAO.findById(empno).get(); //get employee object
		Project newProject = projectDAO.findById(projectId).get(); //get the project object
		
		emp.getProjectAssigned().add(newProject); //assign employee to project
		empDAO.save(emp); //save employee object
		
		return emp; //return the employee object
	}
	
}