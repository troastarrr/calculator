package com.houeghautoliners.calculator.service.mortgage;

import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import com.houeghautoliners.calculator.exception.InvalidRequestException;
import org.junit.Assert;
import org.junit.Test;

public class MaxMortgageLoanServiceTest {

    private AmmortizationMortgageLoanService ammortizationMortgageLoanService = new AmmortizationMortgageLoanService();

    private MaxMortgageLoanService classUnderTest = new MaxMortgageLoanService(ammortizationMortgageLoanService);

    @Test
    public void givenValidRequestThenCalculateMaxMortgage() {
        Mortgage mortgageRequest = generateMortgageRequest();
        Mortgage result = classUnderTest.calculate(mortgageRequest);
        Assert.assertEquals(new Double(432.0), result.getMaxMonthlyPayment());
        Assert.assertEquals(new Double(97894.31502618724), result.getTotalPriceHouse());
        Assert.assertEquals(new Double(77894.31502618724), result.getMortgageTotal());
        Assert.assertEquals(new Double(308.08141329509385), result.getTotalInterest());
    }

    private Mortgage generateMortgageRequest() {
        Mortgage mortgageRequest = new Mortgage();
        mortgageRequest.setInitialDeposit(20000.0);
        mortgageRequest.setMontlyIncome(2000.0);
        mortgageRequest.setInterest(3.0);
        mortgageRequest.setTerm(20);
        mortgageRequest.setMontlyExpenses(800.0);
        mortgageRequest.setAge(18);
        mortgageRequest.setRiskRate(0.36);
        mortgageRequest.setMaxAge(65);
        return mortgageRequest;
    }

    @Test(expected = InvalidRequestException.class)
    public void givenInvalidRequestThenThrowInvalidRequestException() {
        classUnderTest.calculate(null);
    }
}
