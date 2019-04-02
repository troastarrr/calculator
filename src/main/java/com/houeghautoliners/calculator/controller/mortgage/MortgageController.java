package com.houeghautoliners.calculator.controller.mortgage;

import com.houeghautoliners.calculator.ServiceType;
import com.houeghautoliners.calculator.dto.mortgage.AmmortizationMortageRequest;
import com.houeghautoliners.calculator.dto.mortgage.AmmortizationMortgageResponseList;
import com.houeghautoliners.calculator.dto.mortgage.MaxMortgageRequest;
import com.houeghautoliners.calculator.dto.mortgage.MaxMortgageResponse;
import com.houeghautoliners.calculator.entity.mortgage.Ammortization;
import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import com.houeghautoliners.calculator.exception.InvalidServiceTypeException;
import com.houeghautoliners.calculator.factory.mortgage.LoanServiceFactory;
import com.houeghautoliners.calculator.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/mortgage")
public class MortgageController {

    private final static Logger log = LoggerFactory.getLogger(MortgageController.class);

    private ConversionService conversionService;

    public MortgageController(
        @Autowired ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @PostMapping(value = "/max")
    public ResponseEntity calculateMaxMortgage(
        @RequestBody MaxMortgageRequest maxMortgageRequest) throws InvalidServiceTypeException {
        log.info("Calculate max mortgage api :{}", maxMortgageRequest.toString());
        Mortgage maxMortgage = conversionService.convert(maxMortgageRequest, Mortgage.class);
        LoanService<Mortgage, Mortgage> loanService = LoanServiceFactory.getService(ServiceType.MAX);
        Mortgage mortgageResponse = loanService.calculate(maxMortgage);
        MaxMortgageResponse maxMortgageResponse =
            conversionService.convert(mortgageResponse, MaxMortgageResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(maxMortgageResponse);
    }

    @PostMapping(value = "/ammortization")
    public ResponseEntity calculateAmmortizationMortgage(
        @RequestBody AmmortizationMortageRequest ammortizationMortageRequest) throws InvalidServiceTypeException {
        log.info("Calculate ammortization mortgage api :{}", ammortizationMortageRequest.toString());
        Ammortization ammortization = conversionService.convert(ammortizationMortageRequest, Ammortization.class);
        LoanService<Ammortization, List<Ammortization>> loanService =
            LoanServiceFactory.getService(ServiceType.AMMORTIZATION);
        List<Ammortization> ammortizationListmmortization = loanService.calculate(ammortization);
        AmmortizationMortgageResponseList ammortizationMortgageResponseList =
            conversionService.convert(ammortizationListmmortization, AmmortizationMortgageResponseList.class);
        return ResponseEntity.status(HttpStatus.OK).body(ammortizationMortgageResponseList);
    }
}
