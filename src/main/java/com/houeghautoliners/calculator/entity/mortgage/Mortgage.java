package com.houeghautoliners.calculator.entity.mortgage;

public class Mortgage {

    private Double initialDeposit;

    private Integer age;

    private Double montlyIncome;

    private Double interest;

    private Integer term;

    private Double montlyExpenses;

    private Integer maxAge;

    private Double riskRate;

    private Double personalTaxRate;

    private Double maxMonthlyPayment;

    private Double totalPriceHouse;

    private Double mortgageTotal;

    private Double totalInterest;

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

    public Double getMaxMonthlyPayment() {
        return maxMonthlyPayment;
    }

    public void setMaxMonthlyPayment(Double maxMonthlyPayment) {
        this.maxMonthlyPayment = maxMonthlyPayment;
    }

    public Double getTotalPriceHouse() {
        return totalPriceHouse;
    }

    public void setTotalPriceHouse(Double totalPriceHouse) {
        this.totalPriceHouse = totalPriceHouse;
    }

    public Double getMortgageTotal() {
        return mortgageTotal;
    }

    public void setMortgageTotal(Double mortgageTotal) {
        this.mortgageTotal = mortgageTotal;
    }

    public Double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(Double totalInterest) {
        this.totalInterest = totalInterest;
    }
}
