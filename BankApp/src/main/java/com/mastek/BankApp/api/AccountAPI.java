package com.mastek.BankApp.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.BankApp.entities.Account;


@Path("/BankApp/")
public interface AccountAPI {

	// http://localhost:7777/hrapp/employees/list
	@GET		//we do support HTTP method: GET
	@Path("/account/list")	//URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Account> listAllAccounts();
	
	@GET //http method
	@Path("/account/find/{accountId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Account findByAccountId(@PathParam("accountId")int accountId);
	
	@POST //http method
	@Path("/account/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Account registerNewAccount(@BeanParam Account newAccount);
	
}