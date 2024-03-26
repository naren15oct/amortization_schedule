package com.amortschedule.amortization.schedule.service;

//AmortizationScheduleItem.java
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class AmortizationScheduleItem {
	
 private int period;
 private double payment;
 private double principalPaid;
 private double interestPaid;
 
 
 
public AmortizationScheduleItem(int period, double payment, double principalPaid, double interestPaid) {
	super();
	this.period = period;
	this.payment = payment;
	this.principalPaid = principalPaid;
	this.interestPaid = interestPaid;
}

public int getPeriod() {
	return period;
}
public void setPeriod(int period) {
	this.period = period;
}
public double getPayment() {
	return payment;
}
public void setPayment(double payment) {
	this.payment = payment;
}
public double getPrincipalPaid() {
	return principalPaid;
}
public void setPrincipalPaid(double principalPaid) {
	this.principalPaid = principalPaid;
}
public double getInterestPaid() {
	return interestPaid;
}
public void setInterestPaid(double interestPaid) {
	this.interestPaid = interestPaid;
}

 
}