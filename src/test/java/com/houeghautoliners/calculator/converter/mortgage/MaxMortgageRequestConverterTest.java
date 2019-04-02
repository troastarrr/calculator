package com.houeghautoliners.calculator.converter.mortgage;

import com.houeghautoliners.calculator.dto.mortgage.MaxMortgageRequest;
import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import org.junit.Assert;
import org.junit.Test;

public class MaxMortgageRequestConverterTest {

    private MaxMortgageRequestConverter classUnderTest = new MaxMortgageRequestConverter();

    @Test
    public void testConvert() {
        MaxMortgageRequest maxMortgageRequest = new MaxMortgageRequest();
        maxMortgageRequest.setInitialDeposit(1.0);
        maxMortgageRequest.setMontlyIncome(2.0);
        maxMortgageRequest.setInterest(3.0);
        Mortgage mortgage = classUnderTest.convert(maxMortgageRequest);
        Assert.assertEquals(maxMortgageRequest.getInitialDeposit(), mortgage.getInitialDeposit());
        Assert.assertEquals(maxMortgageRequest.getMontlyIncome(), mortgage.getMontlyIncome());
        Assert.assertEquals(maxMortgageRequest.getInterest(), mortgage.getInterest());
    }
}
