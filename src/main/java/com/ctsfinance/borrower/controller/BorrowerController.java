package com.ctsfinance.borrower.controller;


import com.ctsfinance.borrower.model.LoanDetails;
import com.ctsfinance.borrower.service.BorrowerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BorrowerController.class);

    @Autowired
    private BorrowerServiceImpl borrowerService;

    @GetMapping("/search")
    public ResponseEntity<LoanDetails> getBorrowerDetails(@Param("keyword") String keyword) {

        LOGGER.info("Start getBorrowerDetails method :: BorrowerController Class");

        return ResponseEntity.ok(borrowerService.fetchBorrowerDetails(keyword));
    }

    @PostMapping("/save")
    public ResponseEntity<LoanDetails> saveBorrowerDetails(@RequestBody LoanDetails borrower){

        LOGGER.info("Start saveBorrowerDetails method :: BorrowerController Class");

        return ResponseEntity.ok(borrowerService.saveBorrowerDetails(borrower));
    }

    @PutMapping("/update/{loanId}")
    public ResponseEntity<LoanDetails> updateBorrowerDetails(@RequestBody LoanDetails loanDetails, @PathVariable("loanId") Long loanNumber){

        LOGGER.info("Start updateBorrowerDetails method :: BorrowerController Class");

        return ResponseEntity.ok(borrowerService.modifyBorrowerDetails(loanDetails, loanNumber));
    }
}
