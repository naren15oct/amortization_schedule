package com.amortschedule.amortization.schedule.service;

import java.util.ArrayList;
import java.util.List;

import com.amortschedule.amortization.schedule.model.Loan;

public class AmortizationCalculator {
	public static List<AmortizationScheduleItem> calculateAmortizationSchedule(Loan loan) {
        List<AmortizationScheduleItem> amortizationSchedule = new ArrayList<>();
        
        double principal = loan.getPrincipal();
        double interestRate = loan.getInterestRate() / 100 / 12; // Monthly interest rate
        int term = loan.getTerm() * 12; // Total number of payments
        
        // Calculate monthly payment using the formula for a fixed-rate mortgage
        double monthlyPayment = (principal * interestRate) / (1 - Math.pow(1 + interestRate, -term));
        
        // Loop through each payment period to calculate amortization details
        for (int i = 1; i <= term; i++) {
            double interestPaid = principal * interestRate; // Interest payment for this period
            double principalPaid = monthlyPayment - interestPaid; // Principal payment for this period
            principal -= principalPaid; // Remaining principal after payment
            
            // Create an amortization schedule item and add it to the list
            AmortizationScheduleItem scheduleItem = new AmortizationScheduleItem(i, monthlyPayment, principalPaid, interestPaid);
            amortizationSchedule.add(scheduleItem);
        }
        
        return amortizationSchedule;
    }
	
	public static List<AmortizationScheduleItem> calculateAmortizationScheduleWithBaloon(Loan loan, double balloonPayment) {
	
List<AmortizationScheduleItem> amortizationSchedule = new ArrayList<>();
        
        double principal = loan.getPrincipal()-balloonPayment;
        double interestRate = loan.getInterestRate() / 100 / 12; // Monthly interest rate
        int term = loan.getTerm() * 12; // Total number of payments
        
        // Calculate monthly payment using the formula for a fixed-rate mortgage
        double monthlyPayment = (principal * interestRate) / (1 - Math.pow(1 + interestRate, -term));
        
        // Loop through each payment period to calculate amortization details
        for (int i = 1; i <= term; i++) {
            double interestPaid = principal * interestRate; // Interest payment for this period
            double principalPaid = monthlyPayment - interestPaid; // Principal payment for this period
            principal -= principalPaid; // Remaining principal after payment
            
            // Create an amortization schedule item and add it to the list
            AmortizationScheduleItem scheduleItem = new AmortizationScheduleItem(i, monthlyPayment, principalPaid, interestPaid);
            amortizationSchedule.add(scheduleItem);
        }
        
        return amortizationSchedule;
        
	}
	
	public static List<AmortizationScheduleItem> calculateAmortizationScheduleWithBaloonPay(Loan loan, double balloonPayment) {
        List<AmortizationScheduleItem> amortizationSchedule = new ArrayList<>();
        
        double principal = loan.getPrincipal();
        double interestRate = loan.getInterestRate() / 100 / 12; // Monthly interest rate
        int term = loan.getTerm() * 12; // Total number of payments
        
        // Calculate monthly payment using the formula for a fixed-rate mortgage without the balloon payment
        double monthlyPaymentWithoutBalloon = (principal * interestRate) / (1 - Math.pow(1 + interestRate, -term));
        
        // Calculate the remaining balance after term-1 payments without the balloon payment
        double remainingBalanceWithoutBalloon = principal;
        for (int i = 1; i < term; i++) {
            double interestPaid = remainingBalanceWithoutBalloon * interestRate;
            double principalPaid = monthlyPaymentWithoutBalloon - interestPaid;
            remainingBalanceWithoutBalloon -= principalPaid;
        }
        
        // Calculate the monthly payment including the balloon payment
        double monthlyPaymentWithBalloon = (remainingBalanceWithoutBalloon + balloonPayment) * interestRate;
        
        // Loop through each payment period to calculate amortization details
        for (int i = 1; i <= term; i++) {
            double interestPaid = principal * interestRate; // Interest payment for this period
            double principalPaid = monthlyPaymentWithBalloon - interestPaid; // Principal payment for this period
            
            // If it's the last period and balloon payment is due, adjust the principal payment
            if (i == term && balloonPayment > 0) {
                principalPaid += balloonPayment;
            }
            
            principal -= principalPaid; // Remaining principal after payment
            
            // Create an amortization schedule item and add it to the list
            AmortizationScheduleItem scheduleItem = new AmortizationScheduleItem(i, monthlyPaymentWithBalloon, principalPaid, interestPaid);
            amortizationSchedule.add(scheduleItem);
        }
        
        return amortizationSchedule;
    }
}