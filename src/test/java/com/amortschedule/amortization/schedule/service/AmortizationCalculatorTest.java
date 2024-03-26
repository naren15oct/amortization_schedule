package com.amortschedule.amortization.schedule.service;
import org.junit.jupiter.api.Test;

import com.amortschedule.amortization.schedule.model.Loan;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AmortizationCalculatorTest {

    @Test
    public void testCalculateAmortizationSchedule() {
        // Create a loan with principal amount, interest rate, and term
        Loan loan = new Loan(100000, 5.0, 10);

        // Calculate amortization schedule with a balloon payment of 20000
        double balloonPayment = 20000;
        List<AmortizationScheduleItem> schedule = AmortizationCalculator.calculateAmortizationSchedule(loan);

        // Check that the schedule is not null and contains the expected number of periods
        assertNotNull(schedule);
        assertEquals(loan.getTerm() * 12, schedule.size());

        // Check the values of the first schedule item
        AmortizationScheduleItem firstItem = schedule.get(0);
        assertEquals(1, firstItem.getPeriod());
        //assertEquals(805.23, firstItem.getPayment(), 0.01);
        //assertEquals(332.96, firstItem.getPrincipalPaid(), 0.01);
        //assertEquals(472.27, firstItem.getInterestPaid(), 0.01);

        // Add more assertions for other items in the schedule if needed
    }
}