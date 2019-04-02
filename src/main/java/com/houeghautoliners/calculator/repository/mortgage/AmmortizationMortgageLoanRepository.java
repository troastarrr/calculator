package com.houeghautoliners.calculator.repository.mortgage;

import com.houeghautoliners.calculator.entity.mortgage.Ammortization;
import com.houeghautoliners.calculator.repository.LoanRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AmmortizationMortgageLoanRepository implements LoanRepository<Ammortization> {



    @Override
    public Ammortization save(Ammortization ammortization) {
        return ammortization;
    }
}
