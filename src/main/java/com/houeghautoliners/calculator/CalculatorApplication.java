package com.houeghautoliners.calculator;

import com.houeghautoliners.calculator.controller.mortgage.MortgageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.houeghautoliners.calculator"})
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

}
