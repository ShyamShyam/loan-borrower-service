package com.ctsfinance.borrower.repository;


import com.ctsfinance.borrower.model.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowerRepository extends JpaRepository<LoanDetails, Long> {

    @Query(value = "SELECT * FROM LOAN_DETAILS b WHERE b.borrower_name LIKE %?1% OR b.loan_id LIKE %?1% OR b.loan_amount LIKE %?1%", nativeQuery = true)
    List<LoanDetails> fetchAll(String keyword);

}
