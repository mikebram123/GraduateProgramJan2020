package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Project;

@Path("/hrapp/")
public interface ProjectAPI {
	// http://localhost:7777/hrapp/employees/list
	@GET		//we do support HTTP method: GET
	@Path("/project/list")	//URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Project> listAllProjects();
	
	@GET //http method
	@Path("/project/find/{proId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Project findByProjectId(@PathParam("proId")int proId);
	
	@POST //http method
	@Path("/project/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Project registerNewProject(@BeanParam Project newProject);
}
