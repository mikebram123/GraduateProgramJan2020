package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Employee;

@Path("/hrapp/")	//URL pattern to access the current API Interface
public interface EmployeeAPI {

	// http://localhost:7777/hrapp/employees/list
	@GET		//we do support HTTP method: GET
	@Path("/employees/list")	//URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Employee> listAllEmployees();
	
	@GET //http method
	@Path("/employees/find/{empno}")
	@Produces({MediaType.APPLICATION_JSON})
	public Employee findByEmpno(@PathParam("empno")int empno);
	
	@POST //http method
	@Path("/employees/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee registerNewEmployee(@BeanParam Employee newEmployee);
	
}