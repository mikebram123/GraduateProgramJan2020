package com.mastek.BankApp.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_JOINED_HOME_LOAN")
public class HomeLoan extends Loan {
	
	int homeLoanId;
	String provider;
	public int getHomeLoanId() {
		return homeLoanId;
	}
	public void setHomeLoanId(int homeLoanId) {
		this.homeLoanId = homeLoanId;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	@Override
	public String toString() {
		return "HomeLoan [homeLoanId=" + homeLoanId + ", provider=" + provider + ", loanId=" + loanId + ", loanAmount="
				+ loanAmount + "]";
	}
	
	

}
