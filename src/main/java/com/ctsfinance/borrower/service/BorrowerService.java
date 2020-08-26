package com.ctsfinance.borrower.service;

import com.ctsfinance.borrower.model.LoanDetails;

import java.util.List;

public interface BorrowerService {

    List<LoanDetails> fetchBorrowerDetails(String keyword);
    LoanDetails saveBorrowerDetails(LoanDetails borrower);
    LoanDetails modifyBorrowerDetails(LoanDetails loanDetails, Long loanNumber);
}
