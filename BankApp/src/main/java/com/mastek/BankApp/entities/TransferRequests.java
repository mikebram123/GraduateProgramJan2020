package com.mastek.BankApp.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JPA_TRANSFER_REQUESTS")
public class TransferRequests {
	int transferRequestsId;
	String fromAccount;
	String toAccount;
	double amount;
	String description;
	
	Set<Transaction> tr = new HashSet<>();
	
	
	public Set<Transaction> getTr() {
		return tr;
	}
	public void setTr(Set<Transaction> tr) {
		this.tr = tr;
	}
	
	@Id
	public int getTransferRequestsId() {
		return transferRequestsId;
	}
	public void setTransferRequestsId(int transferRequestsId) {
		this.transferRequestsId = transferRequestsId;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transferRequestsId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferRequests other = (TransferRequests) obj;
		if (transferRequestsId != other.transferRequestsId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransferRequests [transferRequestsId=" + transferRequestsId + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", amount=" + amount + ", description=" + description + "]";
	}
	
	

}
