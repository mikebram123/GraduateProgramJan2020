package com.mastek.BankApp.api;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.BankApp.entities.Account;
import com.mastek.BankApp.entities.Customer;

@Path("/BankApp/")
public interface CustomerAPI {
	// http://localhost:7777/hrapp/employees/list
	@GET		//we do support HTTP method: GET
	@Path("/customer/list")	//URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Customer> listAllCustomers();
	
	@GET //http method
	@Path("/customer/find/{customerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Customer findByCustomerId(@PathParam("customerId")int customerId);
	
	@POST //http method
	@Path("/customer/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer registerNewCustomer(@BeanParam Customer newCustomer);
	
	@GET
	@Path("/customer/account/{customerId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Account> getCustomerAccounts(@PathParam("customerId") int customerId);
	
	@POST
	@Path("/customer/account/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Account registerAccountForCustomer(@FormParam("customerId")int customerId, @BeanParam Account newAccount);

}
