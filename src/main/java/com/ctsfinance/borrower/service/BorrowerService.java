package com.ctsfinance.borrower.service;

import com.ctsfinance.borrower.model.LoanDetails;

import java.util.Optional;

public interface BorrowerService {

    LoanDetails fetchBorrowerDetails(String keyword);
    LoanDetails saveBorrowerDetails(LoanDetails borrower);
    LoanDetails modifyBorrowerDetails(LoanDetails loanDetails, Long loanNumber);
}
