package com.houeghautoliners.calculator.dto.mortgage;

import javax.validation.constraints.NotNull;

public class AmmortizationMortageRequest {

    @NotNull
    private Double capital;

    @NotNull
    private Double pay;

    @NotNull
    private Integer periods;

    @NotNull
    private Double interest;

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }
}
