package com.ctsfinance.borrower.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "LOAN_DETAILS", schema = "loanservice")
public class LoanDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "borrower_name")
    private String borrowerName;

    @Column(name = "loan_amount")
    private Long loanAmount;

    @Column(name = "loan_term")
    private String loanTerm;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "property_document")
    private String propertyDocument;

    @Column(name = "ADDRESS1")
    private String addressLine1;

    @Column(name = "ADDRESS2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private Long zipCode;
}
