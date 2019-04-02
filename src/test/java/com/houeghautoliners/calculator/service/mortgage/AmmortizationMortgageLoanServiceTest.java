package com.houeghautoliners.calculator.service.mortgage;

import com.houeghautoliners.calculator.entity.mortgage.Ammortization;
import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import com.houeghautoliners.calculator.exception.InvalidRequestException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AmmortizationMortgageLoanServiceTest {

    private AmmortizationMortgageLoanService classUnderTest = new AmmortizationMortgageLoanService();

    @Test
    public void givenCapitalIsGreaterThanPayThenCalculateAmmortization(){
        List<Ammortization> result = classUnderTest.calculate(generateAmmortizationRequest(5000.0,423.47,12,0.03));
        Assert.assertEquals(12,result.size());
        Ammortization period1 = result.get(0);
        Assert.assertEquals(new Integer(1),period1.getPeriod());
        Assert.assertEquals(new Double(12.5),period1.getAmortizationInterest());
        Assert.assertEquals(new Double(410.97),period1.getAmortizationCapital());
        Assert.assertEquals(new Double(4589.03),period1.getCapital());
    }

    @Test(expected = InvalidRequestException.class)
    public void givenNullRequestThenThrowException(){
        List<Ammortization> result = classUnderTest.calculate(null);
    }

    @Test
    public void givenCapitalIsLessThanPayThenCalculateFirstPeriodOnly(){
        List<Ammortization> result = classUnderTest.calculate(generateAmmortizationRequest(300.0,423.47,12,0.03));
        Assert.assertEquals(1,result.size());
        Ammortization period1 = result.get(0);
        Assert.assertEquals(new Integer(1),period1.getPeriod());
        Assert.assertEquals(new Double(0.75),period1.getAmortizationInterest());
        Assert.assertEquals(new Double(300.0),period1.getAmortizationCapital());
        Assert.assertEquals(new Double(0.0),period1.getCapital());
    }


    public Ammortization generateAmmortizationRequest(Double capital, Double pay, Integer periods, Double interest) {
        Ammortization ammortizationMortageRequest = new Ammortization();
        ammortizationMortageRequest.setCapital(capital);
        ammortizationMortageRequest.setPay(pay);
        ammortizationMortageRequest.setPeriods(periods);
        ammortizationMortageRequest.setInterest(interest);
        return ammortizationMortageRequest;
    }


}
