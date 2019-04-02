package com.houeghautoliners.calculator.converter.mortgage;

import com.houeghautoliners.calculator.dto.mortgage.AmmortizationMortageRequest;
import com.houeghautoliners.calculator.entity.mortgage.Ammortization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AmmortizationMortgageRequestConverter implements Converter<AmmortizationMortageRequest, Ammortization> {

    private final static Logger log = LoggerFactory.getLogger(AmmortizationMortgageRequestConverter.class);

    @Override
    public Ammortization convert(AmmortizationMortageRequest ammortizationMortageRequest) {
        log.info("Converting to Ammortization, AmmortizationMortageRequest:{}", ammortizationMortageRequest.toString());
        Ammortization ammortization = new Ammortization();
        ammortization.setCapital(ammortizationMortageRequest.getCapital());
        ammortization.setPay(ammortizationMortageRequest.getPay());
        ammortization.setPeriods(ammortizationMortageRequest.getPeriods());
        ammortization.setInterest(ammortizationMortageRequest.getInterest());
        return ammortization;
    }
}
