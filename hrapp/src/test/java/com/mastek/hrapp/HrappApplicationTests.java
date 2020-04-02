package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPositions;
import com.mastek.hrapp.entities.Payment;
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
	
	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Autowired
	JobPositionsDAO jobDAO;
	
	//@Test
	void testAddJobPositionDocument() {
		JobPositions jp = new JobPositions();
		jp.setJobId(122);
		jp.setLocation("Leeds");
		jp.setClientName("NHS");
		jp.setSkillsRequired("Java");
		jp.setNumberOfPositions(3);
		
		jp = jobDAO.save(jp);
		
		assertNotNull(jp, "Job Positions not Saved");
	}
	
	//@Test
	void testListAllJobPositions() {
		System.out.println("Print All Job Positions");
		for(JobPositions jp : jobDAO.findAll()) {
			System.out.println(jp);
		}
	}
	
	//@Test
	void testFindByEmployeeSalary(){
		double minSalary = 1000.0;
		double maxSalary= 5000.0;
									//empDAO.findBySalary(minSalary, maxSalary)
		Iterable<Employee> emps = empDAO.findBySalary(minSalary, maxSalary);
		
		System.out.println("All Employees having salary between min: "+minSalary + " and max: " + maxSalary);
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	//@Test
	void testFindEmployeesByDesignation() {
		Iterable<Employee> emps = empDAO.findByDesignation(Designation.MANAGER);
		
		System.out.println("All Employees with Designation as "+ Designation.MANAGER);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	//@Test
	void testCashPaymentAdd() {
		Payment cashP = new Payment();
		cashP.setAmount(100);
		
		cashP = paymentDAO.save(cashP);
		
		System.out.println(cashP);
		assertNotNull(cashP, "Cash Payment not Saved");
	}
	
	//@Test
	void testCardPaymentAdd() {
		CardPayment cardP = new CardPayment();
		cardP.setAmount(100);
		cardP.setCardNumber(111111111113323l);
		cardP.setCardService("VISA");
		
		cardP = paymentDAO.save(cardP);
		System.out.println(cardP);
		
		assertNotNull(cardP,"Card Payment not Saved");
	}
	
	//@Test
	void testChequePaymentAdd() {
		ChequePayment cheqP = new ChequePayment();
		cheqP.setAmount(19230);
		cheqP.setBankName("RBS");
		cheqP.setChequeNumber(2323232);
		
		cheqP=paymentDAO.save(cheqP);
		System.out.println(cheqP);
		assertNotNull(cheqP,"Cheque Payment not Saved");
	}
	
	//@Test
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
	
	//@Test
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
	//@Test
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
	//@Test
	void testListProject() {
		Iterable<Project> pros = projectDAO.findAll();
		assertNotNull(pros,"Department not Found");
		for(Project pro :pros) {
			System.out.println(pro);
		}
	}
	//@Test
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
	//@Test
	void testAssignEmployeeToDepartment() {
		//empSVC.assignEmployeeToDepartment(empno, deptno)
		Employee emp = empSvc.assignEmployeeToDepartment(4,18);
		assertNotNull(emp.getCurrentDepartment(),"Department not Assigned");
	}
	
	//@Test
	void testAssignEmployeeToProject() {
		Employee emp = empSvc.assignEmployeeToProject(14,19);
		assertTrue(emp.getProjectAssigned().size()>0,"Projects Assigned");
	}
	
	//@Test
	void testApplyForJobPosition() {
		int jobId = 122;
		int empno = 11;
		JobPositions jp = empSvc.applyForJobPosition(jobId, empno);
		
		assertNotNull(jp,"Job not Applied");
		
		System.out.println("Applications for Job Id: "+jobId);
		for (Employee applicant : jp.getApplicants()) {
			System.out.println(applicant);
		}
	}

}
