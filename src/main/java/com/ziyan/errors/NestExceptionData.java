package com.ziyan.errors;

import java.io.Serializable;

/**
 * Created by ziyan on 17/5/6.
 */
public class NestExceptionData implements Serializable {

    private int errorCode;
    private String message;

    public NestExceptionData(int errorCode, String msg) {
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
