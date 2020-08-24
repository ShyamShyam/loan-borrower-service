package com.ctsfinance.borrower.exception;

import java.util.Date;

public class CustomException extends RuntimeException{

    private final String message;
    private final String details;
    private final Date date;

    public CustomException(String message, String details, Date date) {
        this.message = message;
        this.details = details;
        this.date = date;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Date getDate() {
        return date;
    }
}
