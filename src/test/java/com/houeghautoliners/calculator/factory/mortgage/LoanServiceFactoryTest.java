package com.houeghautoliners.calculator.factory.mortgage;

import com.houeghautoliners.calculator.ServiceType;
import com.houeghautoliners.calculator.exception.InvalidServiceTypeException;
import com.houeghautoliners.calculator.service.LoanService;
import com.houeghautoliners.calculator.service.mortgage.AmmortizationMortgageLoanService;
import com.houeghautoliners.calculator.service.mortgage.MaxMortgageLoanService;
import org.junit.Assert;
import org.junit.Test;

public class LoanServiceFactoryTest {

    @Test
    public void givenMaxServiceTypeThenReturnService() throws InvalidServiceTypeException {
        LoanService loanService = LoanServiceFactory.getService(ServiceType.MAX);
        Assert.assertNotNull(loanService);
        Assert.assertTrue(loanService instanceof MaxMortgageLoanService);
    }

    @Test
    public void givenAmmortizationServiceTypeThenReturnService() throws InvalidServiceTypeException {
        LoanService loanService = LoanServiceFactory.getService(ServiceType.AMMORTIZATION);
        Assert.assertNotNull(loanService);
        Assert.assertTrue(loanService instanceof AmmortizationMortgageLoanService);
    }

    @Test(expected = InvalidServiceTypeException.class)
    public void givenInvalidServiceTypeThenThrowInvalidServiceTypeException() throws InvalidServiceTypeException {
        LoanServiceFactory.getService(ServiceType.CAR);
    }

    @Test(expected = InvalidServiceTypeException.class)
    public void givenNullServiceTypeThenThrowInvalidServiceTypeException() throws InvalidServiceTypeException {
        LoanServiceFactory.getService(null);
    }
}
