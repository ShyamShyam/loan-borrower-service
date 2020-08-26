package com.ctsfinance.borrower.service;

import com.ctsfinance.borrower.controller.BorrowerController;
import com.ctsfinance.borrower.exception.CustomException;
import com.ctsfinance.borrower.model.LoanDetails;
import com.ctsfinance.borrower.repository.BorrowerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService{

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowerController.class);

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public List<LoanDetails> fetchBorrowerDetails(String keyword) {

        LOGGER.info("Enter fetchBorrowerDetails method :: BorrowerServiceImpl Class");

        List<LoanDetails> loanDetails = borrowerRepository.fetchAll(keyword);

        if(loanDetails == null)
            throw new CustomException("No record found", "Please try with different keyword", new Date());

        return loanDetails;
    }

    @Override
    public LoanDetails saveBorrowerDetails(LoanDetails borrower){

        LOGGER.info("Enter saveBorrowerDetails method :: BorrowerServiceImpl Class");

        LoanDetails loanDetails = borrowerRepository.save(borrower);

        if(loanDetails == null)
            throw new CustomException("Not saved", "Something is wrong", new Date());

        return loanDetails;
    }

    @Override
    public LoanDetails modifyBorrowerDetails(LoanDetails borrower, Long loanNumber){

        LOGGER.info("Enter modifyBorrowerDetails method :: BorrowerServiceImpl Class");

        if (borrowerRepository.findById(loanNumber).isPresent()) {
            borrower.setLoanId(loanNumber);
            return borrowerRepository.save(borrower);
        }else{

            throw new CustomException("Not updated", "Something is wrong", new Date());
        }
    }
}
