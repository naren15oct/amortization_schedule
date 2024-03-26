package com.amortschedule.amortization.schedule.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class Loan {
	
    private double principal;
    private double interestRate;
    private int term;
    
    
    
	public Loan(double principal, double interestRate, int term) {
		super();
		this.principal = principal;
		this.interestRate = interestRate;
		this.term = term;
	}
	
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}

    
}