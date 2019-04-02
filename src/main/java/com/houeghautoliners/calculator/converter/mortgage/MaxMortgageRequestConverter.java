package com.houeghautoliners.calculator.converter.mortgage;

import com.houeghautoliners.calculator.dto.mortgage.MaxMortgageRequest;
import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MaxMortgageRequestConverter implements Converter<MaxMortgageRequest, Mortgage> {

    private final static Logger log = LoggerFactory.getLogger(MaxMortgageRequestConverter.class);

    @Value("${default.initial.term}")
    private Integer term;

    @Value("${default.initial.maxAge}")
    private Integer maxAge;

    @Value("${default.initial.riskRate}")
    private Double riskRate;

    @Value("${default.initial.personalTaxRate}")
    private Double personalTaxRate;

    @Value("${default.initial.age}")
    private Integer age;

    @Override
    public Mortgage convert(MaxMortgageRequest maxMortgageRequest) {
        log.info("Converting to Mortgage, MaxMortgageRequest:{}", maxMortgageRequest.toString());
        Mortgage mortgage = new Mortgage();
        if (maxMortgageRequest.getAge() != null) {
            mortgage.setAge(maxMortgageRequest.getAge());
        } else {
            log.info("Setting to default value :{}", age);
            mortgage.setAge(age);
        }
        if (maxMortgageRequest.getPersonalTaxRate() != null) {
            mortgage.setPersonalTaxRate(maxMortgageRequest.getPersonalTaxRate());
        } else {
            log.info("Setting to default value :{}", personalTaxRate);
            mortgage.setPersonalTaxRate(personalTaxRate);
        }
        if (maxMortgageRequest.getRiskRate() != null) {
            mortgage.setRiskRate(maxMortgageRequest.getRiskRate());
        } else {
            log.info("Setting to default value :{}", riskRate);
            mortgage.setRiskRate(riskRate);
        }
        if (maxMortgageRequest.getMaxAge() != null) {
            mortgage.setMaxAge(maxMortgageRequest.getMaxAge());
        } else {
            log.info("Setting to default value :{}", maxAge);
            mortgage.setMaxAge(maxAge);
        }
        if (maxMortgageRequest.getTerm() != null) {
            mortgage.setTerm(maxMortgageRequest.getTerm());
        } else {
            log.info("Setting to default value :{}", term);
            mortgage.setTerm(term);
        }
        mortgage.setInitialDeposit(maxMortgageRequest.getInitialDeposit());
        mortgage.setMontlyIncome(maxMortgageRequest.getMontlyIncome());
        mortgage.setInterest(maxMortgageRequest.getInterest());
        mortgage.setMontlyExpenses(maxMortgageRequest.getMontlyExpenses());
        return mortgage;
    }
}
