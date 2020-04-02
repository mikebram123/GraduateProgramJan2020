package com.mastek.BankApp.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.BankApp.entities.Transaction;

@Path("/BankApp/")
public interface TransactionAPI {
	
	@GET		//we do support HTTP method: GET
	@Path("/transaction/list")	//URL Path to access this method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Transaction> listAllTransactions();
	
	@GET //http method
	@Path("/transaction/find/{transactionId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Transaction findByTransactionId(@PathParam("transactionId")int transactionId);
	
	@POST //http method
	@Path("/transaction/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction registerNewTransaction(@BeanParam Transaction newTransaction);
}
