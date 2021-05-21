package com.example.projectspendingcontrol.dto;

public class ErrorDto {

    private String error;
    private String message;

    public ErrorDto() {
    }

    public ErrorDto(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDto convertPaymentInError(Long id){
        if(id == -1L){
            return new ErrorDto("400", "Card does not belong to this account");
        }else if(id == -2L){
            return new ErrorDto("400", "Wrong payment type");
        }else if(id == -3L){
            return new ErrorDto("400", "Debit can't have more than 1 plot");
        }
        return new ErrorDto("400", "Account id does not exist");


    }
}
