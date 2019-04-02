package com.houeghautoliners.calculator.converter.mortgage;

import com.houeghautoliners.calculator.dto.mortgage.AmmortizationMortageResponse;
import com.houeghautoliners.calculator.dto.mortgage.AmmortizationMortgageResponseList;
import com.houeghautoliners.calculator.entity.mortgage.Ammortization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmmortizationMortgageResponseConverter
    implements Converter<List<Ammortization>, AmmortizationMortgageResponseList> {

    private final static Logger log = LoggerFactory.getLogger(AmmortizationMortgageResponseConverter.class);

    @Override
    public AmmortizationMortgageResponseList convert(List<Ammortization> ammortizations) {
        AmmortizationMortgageResponseList ammortizationMortgageResponseList = new AmmortizationMortgageResponseList();
        for (Ammortization ammortization : ammortizations) {
            log.info("Converting to AmmortizationMortageResponse, AmmortizationMortageRequest:{}", ammortization.toString());
            ammortizationMortgageResponseList.addAmmortization(
                new AmmortizationMortageResponse(ammortization.getPeriod(), ammortization.getAmortizationInterest(),
                    ammortization.getAmortizationCapital(), ammortization.getCapital()));
        }
        return ammortizationMortgageResponseList;
    }

}
