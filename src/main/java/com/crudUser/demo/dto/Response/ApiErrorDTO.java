package com.crudUser.demo.dto.Response;

public class ApiErrorDTO {

    private int status;
    private String error;
    private String message;

    public ApiErrorDTO(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;

    }

    public int getStatus() { return status; }

    public String getError() { return error; }

    public String getMessage() { return message; }
}
