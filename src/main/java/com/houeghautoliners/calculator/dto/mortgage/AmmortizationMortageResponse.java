package com.houeghautoliners.calculator.dto.mortgage;

public class AmmortizationMortageResponse {

    private final Integer period;

    private final Double amortizationInterest;

    private final Double amortizationCapital;

    private final Double remainingCapital;

    public AmmortizationMortageResponse(Integer period, Double amortizationInterest, Double amortizationCapital,
                                        Double remainingCapital) {
        this.period = period;
        this.amortizationInterest = amortizationInterest;
        this.amortizationCapital = amortizationCapital;
        this.remainingCapital = remainingCapital;
    }

    public Integer getPeriod() {
        return period;
    }

    public Double getAmortizationInterest() {
        return amortizationInterest;
    }

    public Double getAmortizationCapital() {
        return amortizationCapital;
    }

    public Double getRemainingCapital() {
        return remainingCapital;
    }

    @Override
    public String toString() {
        return "AmmortizationMortageResponse{" +
               "period=" + period +
               ", amortizationInterest=" + amortizationInterest +
               ", amortizationCapital=" + amortizationCapital +
               ", remainingCapital=" + remainingCapital +
               '}';
    }
}
