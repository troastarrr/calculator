package com.houeghautoliners.calculator.factory.mortgage;

import com.houeghautoliners.calculator.ServiceType;
import com.houeghautoliners.calculator.exception.InvalidServiceTypeException;
import com.houeghautoliners.calculator.service.LoanService;
import com.houeghautoliners.calculator.service.mortgage.AmmortizationMortgageLoanService;
import com.houeghautoliners.calculator.service.mortgage.MaxMortgageLoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LoanServiceFactory {

    private final static Logger log = LoggerFactory.getLogger(LoanServiceFactory.class);

    private final static Map<ServiceType, LoanService> SERVICE_TYPE_LOAN_SERVICE_MAP;

    static {
        SERVICE_TYPE_LOAN_SERVICE_MAP = new HashMap<>();
        AmmortizationMortgageLoanService ammortizationMortgageLoanService = new AmmortizationMortgageLoanService();
        SERVICE_TYPE_LOAN_SERVICE_MAP.put(ServiceType.MAX, new MaxMortgageLoanService(ammortizationMortgageLoanService));
        SERVICE_TYPE_LOAN_SERVICE_MAP.put(ServiceType.AMMORTIZATION, ammortizationMortgageLoanService);
    }

    public static LoanService getService(ServiceType serviceType) throws InvalidServiceTypeException {
        if (serviceType == null || SERVICE_TYPE_LOAN_SERVICE_MAP.get(serviceType) == null) {
            final String errorMessage = "Unknown or not yet implemented service type :" + serviceType;
            log.error(errorMessage);
            throw new InvalidServiceTypeException(errorMessage);
        }
        return SERVICE_TYPE_LOAN_SERVICE_MAP.get(serviceType);
    }
}
