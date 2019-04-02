package com.houeghautoliners.calculator.repository.mortgage;

import com.houeghautoliners.calculator.entity.mortgage.Mortgage;
import com.houeghautoliners.calculator.repository.LoanRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MaxMortgageLoanRepository implements LoanRepository<Mortgage> {

    @Override
    public Mortgage save(Mortgage mortgage) {
        return mortgage;
    }
}
