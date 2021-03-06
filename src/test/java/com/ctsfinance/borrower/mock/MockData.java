package com.ctsfinance.borrower.mock;

import com.ctsfinance.borrower.model.LoanDetails;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockData {

    public List<LoanDetails> getLoanDetails(){

        List<LoanDetails> loanDetailsList = new ArrayList<>();

        LoanDetails loanDetails = new LoanDetails();

        loanDetails.setLoanId(1l);
        loanDetails.setUserId(1l);
        loanDetails.setBorrowerName("Shyam");
        loanDetails.setLoanAmount(5000l);
        loanDetails.setLoanTerm("not applicable");
        loanDetails.setLoanType("Bicycle");
        loanDetails.setPropertyDocument("12th Marksheet");
        loanDetails.setAddressLine1("HRBR Layout");
        loanDetails.setAddressLine2("");
        loanDetails.setCity("Bangalore");
        loanDetails.setState("KA");
        loanDetails.setZipCode(560044l);

        loanDetailsList.add(loanDetails);

        return loanDetailsList;
    }

    public LoanDetails getLoanDetail(){

        LoanDetails loanDetails = new LoanDetails();

        loanDetails.setLoanId(1l);
        loanDetails.setUserId(1l);
        loanDetails.setBorrowerName("Shyam");
        loanDetails.setLoanAmount(5000l);
        loanDetails.setLoanTerm("not applicable");
        loanDetails.setLoanType("Bicycle");
        loanDetails.setPropertyDocument("12th Marksheet");
        loanDetails.setAddressLine1("HRBR Layout");
        loanDetails.setAddressLine2("");
        loanDetails.setCity("Bangalore");
        loanDetails.setState("KA");
        loanDetails.setZipCode(560044l);

        return loanDetails;
    }

    public ResponseEntity<LoanDetails> getData(){

        LoanDetails loanDetails = new LoanDetails();

        loanDetails.setLoanId(1l);
        loanDetails.setUserId(1l);
        loanDetails.setBorrowerName("Shyam");
        loanDetails.setLoanAmount(5000l);

        return ResponseEntity.ok(loanDetails);
    }
}
