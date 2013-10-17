package com.guide.city.commands.errors;


import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

public class ErrorObject {

    @JsonView(Views.Public.class)
    private String message;

    @JsonView(Views.Public.class)
    private int errorCode;

    public ErrorObject(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.message = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
