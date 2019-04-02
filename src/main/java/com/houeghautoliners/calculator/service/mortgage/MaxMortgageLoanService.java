package com.houeghautoliners.calculator.service.mortgage;

import com.houeghautoliners.calculator.entity.mortgage.Ammortization;
import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import com.houeghautoliners.calculator.exception.InvalidRequestException;
import com.houeghautoliners.calculator.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaxMortgageLoanService implements LoanService<Mortgage, Mortgage> {

    private final static Logger log = LoggerFactory.getLogger(MaxMortgageLoanService.class);

    private final static int ANNUM = 12;

    private final AmmortizationMortgageLoanService ammortizationMortgageLoanService;

    public MaxMortgageLoanService(@Autowired AmmortizationMortgageLoanService ammortizationMortgageLoanService) {
        this.ammortizationMortgageLoanService = ammortizationMortgageLoanService;
    }

    @Override
    public Mortgage calculate(Mortgage mortgage) {
        if (mortgage == null) {
            throw new InvalidRequestException("Invalid Mortgage Request");
        }
        log.info("Calculating Max Mortgage loan :{}", mortgage);
        Double maxMonthlyPay =
            calculateMaxPay(mortgage.getMontlyIncome(), mortgage.getMontlyExpenses(),
                mortgage.getRiskRate());
        Integer periodRequested = calculatePeriodsRequested(mortgage.getTerm());
        Integer totalPeriods =
            calculateMaxTerm(mortgage.getAge(), mortgage.getMaxAge(), periodRequested);
        Double mortgageTotal =
            calculateMortgage(maxMonthlyPay, getInterestByAnnum(mortgage.getInterest()), totalPeriods);
        Double totalPriceHouse = getTotalPriceHouse(mortgage.getInitialDeposit(), mortgageTotal);
        Ammortization ammortizationMortageRequest =
            wrapAmmortizationRequest(mortgage.getTerm(), mortgage.getInterest(), maxMonthlyPay, mortgageTotal);
        mortgage.setMaxMonthlyPayment(maxMonthlyPay);
        mortgage.setTotalPriceHouse(totalPriceHouse);
        mortgage.setMortgageTotal(mortgageTotal);
        mortgage.setTotalInterest(calculateAmmortizationTotalInterest(ammortizationMortageRequest));
        return mortgage;
    }

    private Double calculateMaxPay(Double monthlyIncome, Double monthlyExpenses, Double riskRate) {
        log.info("Calculating Max Pay ... monthlyIncome: {}, monthlyExpenses: {} , riskRate: {}", monthlyIncome,
            monthlyExpenses, riskRate);
        return (monthlyIncome - monthlyExpenses) * riskRate;
    }

    private Integer calculatePeriodsRequested(Integer term) {
        log.info("Calculating Periods Requested ... term: {}", term);
        return term * ANNUM;
    }

    private Integer calculateMaxTerm(Integer age, Integer maxAge, Integer periodsRequested) {
        log.info("Calculating Max Term ... age: {}, maxAge: {} , periodsRequested: {}", age, maxAge, periodsRequested);
        Integer maxPeriods = ((maxAge - age) * ANNUM);
        if (maxPeriods > periodsRequested) {
            return periodsRequested;
        } else {
            return maxPeriods;
        }
    }

    private Double calculateMortgage(Double maxMontlyPayment, Double interest, Integer totalPeriods) {
        log.info("Calculating Mortgage ... maxMontlyPayment: {}, interest: {} , totalPeriods: {}", maxMontlyPayment,
            interest, totalPeriods);
        interest = (((1 - (Math.pow(1 + (interest / 100), -totalPeriods))))) / (interest / 100);
        return maxMontlyPayment * interest;
    }

    private Double getInterestByAnnum(Double interest) {
        return interest / ANNUM;
    }

    private Double getTotalPriceHouse(Double initialDeposit, Double mortgageTotal) {
        return mortgageTotal + initialDeposit;
    }

    private Ammortization wrapAmmortizationRequest(Integer term, Double interest,
                                                   Double maxMonthlyPay, Double mortgageTotal) {
        Ammortization ammortizationMortageRequest = new Ammortization();
        ammortizationMortageRequest.setCapital(mortgageTotal);
        ammortizationMortageRequest.setPay(maxMonthlyPay);
        ammortizationMortageRequest.setPeriods(term);
        ammortizationMortageRequest.setInterest(getInterestByAnnum(interest / 100));
        return ammortizationMortageRequest;
    }

    private Double calculateAmmortizationTotalInterest(Ammortization ammortizationMortageRequest) {
        log.info("Calculating Ammortization Total Interest {} : ", ammortizationMortageRequest);
        return ammortizationMortgageLoanService.calculate(ammortizationMortageRequest).stream()
            .mapToDouble(value -> value.getAmortizationInterest()).sum();
    }
}
