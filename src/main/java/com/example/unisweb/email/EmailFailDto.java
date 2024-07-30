package com.example.unisweb.email;

public class EmailFailDto {

    private String errorMessage;

    // Constructors
    public EmailFailDto() {
    }

    public EmailFailDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getters and setters
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
