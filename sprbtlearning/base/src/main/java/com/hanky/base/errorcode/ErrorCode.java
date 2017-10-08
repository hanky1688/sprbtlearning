package com.hanky.base.errorcode;

public class ErrorCode {
    private String code;
    private String message;

    public ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }


    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return code() + ":" + message();
    }
}
