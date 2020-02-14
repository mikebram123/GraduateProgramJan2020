package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.DepartmentAPI;
import com.mastek.hrapp.apis.EmployeeAPI;
import com.mastek.hrapp.apis.ProjectAPI;
import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Project;

@Component //marking the class as bean to be created
@Scope("singleton") //singleton:one object used across test cases, prototype: one object per request
public class EmployeeService implements EmployeeAPI, DepartmentAPI,ProjectAPI{

	String exampleProperty;
	
	//declare all the entity DAOs to perform operation across multiple entities
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;
	
	@Autowired
	JobPositionsDAO jobsDAO;
	
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
	
	@Transactional
	public JobPositions applyForJobPosition(int jobId, int empno) {
		JobPositions job = jobsDAO.findById(jobId).get();
		Employee emp = empDAO.findById(empno).get();
		//adding employee object in applicants collection
		job.getApplicants().add(emp);
		
		job = jobsDAO.save(job);
		return job;
	}

	@Override
	public Iterable<Employee> listAllEmployees() {
		System.out.println("Listing all Employees");
		return empDAO.findAll();
	}

	@Override
	public Employee findByEmpno(int empno) {
		return empDAO.findById(empno).get();
	}

	@Override
	public Employee registerNewEmployee(Employee newEmployee) {
		newEmployee = empDAO.save(newEmployee);
		return newEmployee;
	}

	@Override
	public Iterable<Department> listAllDepartment() {
		return deptDAO.findAll();
	}

	@Override
	public Department findByDepId(int depId) {
		return deptDAO.findById(depId).get();
	}

	@Override
	public Department registerNewDepartment(Department newDepartment) {
		newDepartment = deptDAO.save(newDepartment);
		return newDepartment;
	}

	@Override
	public Iterable<Project> listAllProjects() {
		return projectDAO.findAll();
	}

	@Override
	public Project findByProjectId(int proId) {
		return projectDAO.findById(proId).get();
	}

	@Override
	public Project registerNewProject(Project newProject) {
		newProject = projectDAO.save(newProject);
		return newProject;
	}
	
	
}
