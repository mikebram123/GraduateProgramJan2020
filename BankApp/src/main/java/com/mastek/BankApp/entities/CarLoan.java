package com.mastek.BankApp.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_JOINED_CAR_LOAN")
public class CarLoan extends Loan {

	int carLoanId;
	String carLoanProvider;
	
	public CarLoan() {
		// TODO Auto-generated constructor stub
	}

	public int getCarLoanId() {
		return carLoanId;
	}

	public void setCarLoanId(int carLoanId) {
		this.carLoanId = carLoanId;
	}

	public String getCarLoanProvider() {
		return carLoanProvider;
	}

	public void setCarLoanProvider(String carLoanProvider) {
		this.carLoanProvider = carLoanProvider;
	}

	@Override
	public String toString() {
		return "CarLoan [carLoanId=" + carLoanId + ", carLoanProvider=" + carLoanProvider + ", loanId=" + loanId
				+ ", loanAmount=" + loanAmount + "]";
	}
	
	
	
	
	
}
