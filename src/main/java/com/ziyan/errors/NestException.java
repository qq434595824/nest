package com.ziyan.errors;

/**
 * Created by ziyan on 17/5/6.
 */
public class NestException extends RuntimeException {

    private NestExceptionData data;

    public NestException(ErrorCode code) {
        super(code.getMessage());
        data = new NestExceptionData(code.getCode(), code.getMessage());
    }

    public NestException(ErrorCode code, String extInfo) {
        super(code.getMessage() + extInfo);
        data = new NestExceptionData(code.getCode(), code.getMessage() + ":" + extInfo);
    }


    public NestExceptionData getData() {
        return data;
    }
}
