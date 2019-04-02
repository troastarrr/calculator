package com.houeghautoliners.calculator.service.mortgage;

import com.houeghautoliners.calculator.entity.mortgage.Ammortization;
import com.houeghautoliners.calculator.exception.InvalidRequestException;
import com.houeghautoliners.calculator.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmmortizationMortgageLoanService implements LoanService<Ammortization, List<Ammortization>> {

    private final static Logger log = LoggerFactory.getLogger(AmmortizationMortgageLoanService.class);

    @Override
    public List<Ammortization> calculate(Ammortization ammortizationMortageRequest) {
        if (ammortizationMortageRequest == null) {
            throw new InvalidRequestException("Invalid Ammortization Request");
        }
        log.info("Calculating ammortization: {} ", ammortizationMortageRequest);
        List<Ammortization> ammortizationMortageResponse = new ArrayList<>();
        Double capital = ammortizationMortageRequest.getCapital();
        Double pay = ammortizationMortageRequest.getPay();
        Double interest = ammortizationMortageRequest.getInterest();
        Integer periods = ammortizationMortageRequest.getPeriods();
        Double amortizationInterest;
        Double amortizationCapital;
        for (int period = 1; period <= periods; period++) {
            amortizationInterest = capital * (interest / 12);
            if (capital < pay) {
                pay = capital + amortizationInterest;
                amortizationCapital = pay - amortizationInterest;
                wrapAndAdd(ammortizationMortageResponse, period, amortizationInterest, capital - amortizationCapital,
                    capital);
                break;
            } else {
                amortizationCapital = pay - amortizationInterest;
                capital = capital - amortizationCapital;
                wrapAndAdd(ammortizationMortageResponse, period, amortizationInterest, capital, amortizationCapital);
            }
        }
        return ammortizationMortageResponse;
    }

    private void wrapAndAdd(List<Ammortization> ammortizationMortageResponse, int period,
                            Double amortizationInterest, Double capital,
                            Double amortizationCapital) {
        Ammortization ammortization = new Ammortization();
        ammortization.setPeriod(period);
        ammortization.setAmortizationInterest(amortizationInterest);
        ammortization.setAmortizationCapital(amortizationCapital);
        ammortization.setCapital(capital);
        ammortizationMortageResponse.add(ammortization);
    }

}

