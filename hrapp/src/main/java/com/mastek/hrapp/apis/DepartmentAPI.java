package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Department;

@Path("/hrapp/")
public interface DepartmentAPI {

	// http://localhost:7777/hrapp/employees/list
	@GET		//we do support HTTP method: GET
	@Path("/department/list")	//URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Department> listAllDepartment();
	
	@GET //http method
	@Path("/department/find/{depId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Department findByDepId(@PathParam("depId")int depId);
	
	@POST //http method
	@Path("/department/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Department registerNewDepartment(@BeanParam Department newDepartment);
	
	
}
