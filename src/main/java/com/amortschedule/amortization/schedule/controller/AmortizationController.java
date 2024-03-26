package com.amortschedule.amortization.schedule.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amortschedule.amortization.schedule.model.Loan;
import com.amortschedule.amortization.schedule.service.AmortizationCalculator;
import com.amortschedule.amortization.schedule.service.AmortizationScheduleItem;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/amortization")
//@Api(value = "Loan Amortization Schedule", description = "Calculate the amortization Schdule for different loans")
public class AmortizationController {

	/*
	 @Autowired AmortizationCalculator amortCalulator;
	 */
	
	@GetMapping("/welcome")
	public String welcomeMethod() {
		return "Welcome to Amort Calculator !!..";
	}
	
    @PostMapping("/calculate")
    public List<AmortizationScheduleItem> calculateAmortization(@RequestBody Loan loan) {
        return AmortizationCalculator.calculateAmortizationSchedule(loan);
    }
    
    @PostMapping("/calculate/withbaloonpay/{baloonpayment}")
    public List<AmortizationScheduleItem> calculateAmortizationScheduleWithBaloonPay(@RequestBody Loan loan,@PathVariable double baloonpayment ) {
    	return AmortizationCalculator.calculateAmortizationScheduleWithBaloon(loan,baloonpayment);
    	//return AmortizationCalculator.calculateAmortizationScheduleWithBaloonPay(loan,baloonpayment);
    }
}
