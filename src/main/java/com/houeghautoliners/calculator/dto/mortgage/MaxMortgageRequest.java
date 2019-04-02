package com.houeghautoliners.calculator.dto.mortgage;


import javax.validation.constraints.NotNull;

public class MaxMortgageRequest {

    @NotNull
    private Double initialDeposit;

    @NotNull
    private Double montlyIncome;

    @NotNull
    private Double interest;

    @NotNull
    private Double montlyExpenses;

    private Integer age;

    private Integer term;

    private Integer maxAge;

    private Double riskRate;

    private Double personalTaxRate;

    public Double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(Double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMontlyIncome() {
        return montlyIncome;
    }

    public void setMontlyIncome(Double montlyIncome) {
        this.montlyIncome = montlyIncome;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Double getMontlyExpenses() {
        return montlyExpenses;
    }

    public void setMontlyExpenses(Double montlyExpenses) {
        this.montlyExpenses = montlyExpenses;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Double getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(Double riskRate) {
        this.riskRate = riskRate;
    }

    public Double getPersonalTaxRate() {
        return personalTaxRate;
    }

    public void setPersonalTaxRate(Double personalTaxRate) {
        this.personalTaxRate = personalTaxRate;
    }

    @Override
    public String toString() {
        return "MaxMortgageRequest{" +
               "initialDeposit=" + initialDeposit +
               ", age=" + age +
               ", montlyIncome=" + montlyIncome +
               ", interest=" + interest +
               ", term=" + term +
               ", montlyExpenses=" + montlyExpenses +
               ", maxAge=" + maxAge +
               ", riskRate=" + riskRate +
               ", personalTaxRate=" + personalTaxRate +
               '}';
    }

}
