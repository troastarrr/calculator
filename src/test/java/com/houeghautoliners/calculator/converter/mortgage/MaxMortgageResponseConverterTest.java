package com.houeghautoliners.calculator.converter.mortgage;

import com.houeghautoliners.calculator.dto.mortgage.MaxMortgageResponse;
import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import org.junit.Assert;
import org.junit.Test;

public class MaxMortgageResponseConverterTest {

    private MaxMortgageResponseConverter classUnderTest = new MaxMortgageResponseConverter();

    @Test
    public void testConvert() {
        Mortgage mortgage = new Mortgage();
        mortgage.setMaxMonthlyPayment(1.0);
        mortgage.setTotalPriceHouse(2.0);
        mortgage.setMortgageTotal(3.0);
        mortgage.setTotalInterest(4.0);
        MaxMortgageResponse maxMortgageResponse = classUnderTest.convert(mortgage);
        Assert.assertEquals(mortgage.getMaxMonthlyPayment(),maxMortgageResponse.getMaxMonthlyPayment());
        Assert.assertEquals(mortgage.getTotalPriceHouse(),maxMortgageResponse.getTotalPriceHouse());
        Assert.assertEquals(mortgage.getMortgageTotal(),maxMortgageResponse.getMortgageTotal());
        Assert.assertEquals(mortgage.getTotalPriceHouse(),maxMortgageResponse.getTotalPriceHouse());
    }

}
