package com.aichat.exception;

@SuppressWarnings("serial")
public class ApiException extends Exception {

    private int code;
    private Object data;

    public ApiException(int errorCode, String message) {
        super(message);
        this.setCode(errorCode);
    }

    public ApiException(int errorCode, String message, Object data) {
        super(message);
        this.setCode(errorCode);
        this.setData(data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
