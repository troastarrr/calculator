package com.houeghautoliners.calculator.dto.mortgage;

import java.util.ArrayList;
import java.util.List;

public class AmmortizationMortgageResponseList {

    private List<AmmortizationMortageResponse> ammortizationMortageResponseList = new ArrayList<>();


    public List<AmmortizationMortageResponse> getAmmortizationMortageResponseList() {
        return ammortizationMortageResponseList;
    }

    public void addAmmortization(AmmortizationMortageResponse ammortizationMortageResponse) {
        ammortizationMortageResponseList.add(ammortizationMortageResponse);
    }
}
