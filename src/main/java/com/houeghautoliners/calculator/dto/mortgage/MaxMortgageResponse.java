package com.houeghautoliners.calculator.dto.mortgage;

public class MaxMortgageResponse {

    private final Double maxMonthlyPayment;

    private final Double totalPriceHouse;

    private final Double mortgageTotal;

    private final Double totalInterest;

    public MaxMortgageResponse(Double maxMonthlyPayment, Double totalPriceHouse, Double mortgageTotal,
                               Double totalInterest) {
        this.maxMonthlyPayment = maxMonthlyPayment;
        this.totalPriceHouse = totalPriceHouse;
        this.mortgageTotal = mortgageTotal;
        this.totalInterest = totalInterest;
    }

    public Double getMaxMonthlyPayment() {
        return maxMonthlyPayment;
    }

    public Double getTotalPriceHouse() {
        return totalPriceHouse;
    }


    public Double getMortgageTotal() {
        return mortgageTotal;
    }

    public Double getTotalInterest() {
        return totalInterest;
    }
}
