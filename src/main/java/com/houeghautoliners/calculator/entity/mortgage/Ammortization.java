package com.houeghautoliners.calculator.entity.mortgage;

public class Ammortization {

    private Double capital;

    private Double pay;

    private Integer periods;

    private Double interest;

    private Integer period;

    private Double amortizationInterest;

    private Double amortizationCapital;

    private Double remainingCapital;

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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getAmortizationInterest() {
        return amortizationInterest;
    }

    public void setAmortizationInterest(Double amortizationInterest) {
        this.amortizationInterest = amortizationInterest;
    }

    public Double getAmortizationCapital() {
        return amortizationCapital;
    }

    public void setAmortizationCapital(Double amortizationCapital) {
        this.amortizationCapital = amortizationCapital;
    }

    public Double getRemainingCapital() {
        return remainingCapital;
    }

    public void setRemainingCapital(Double remainingCapital) {
        this.remainingCapital = remainingCapital;
    }
}
