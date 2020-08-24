package com.ctsfinance.borrower.exception;

import java.util.Date;

public class ErrorResponse {

    private final String message;
    private final String details;
    private final Date date;

    public ErrorResponse(String message, String details, Date date) {
        this.message = message;
        this.details = details;
        this.date = date;
    }

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
