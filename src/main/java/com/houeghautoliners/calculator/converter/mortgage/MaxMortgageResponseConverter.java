package com.houeghautoliners.calculator.converter.mortgage;

import com.houeghautoliners.calculator.dto.mortgage.MaxMortgageResponse;
import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MaxMortgageResponseConverter implements Converter<Mortgage, MaxMortgageResponse> {

    private final static Logger log = LoggerFactory.getLogger(MaxMortgageResponseConverter.class);

    @Override
    public MaxMortgageResponse convert(Mortgage mortgage) {
        log.info("Converting to MaxMortgageResponse, Mortgage:{}", mortgage.toString());
        MaxMortgageResponse maxMortgageResponse =
            new MaxMortgageResponse(mortgage.getMaxMonthlyPayment(), mortgage.getTotalPriceHouse(),
                mortgage.getMortgageTotal(), mortgage.getTotalInterest());
        return maxMortgageResponse;
    }
}
