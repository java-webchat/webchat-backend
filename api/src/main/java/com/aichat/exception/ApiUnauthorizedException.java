package com.aichat.exception;

@SuppressWarnings("serial")
public class ApiUnauthorizedException extends ApiException {

    public ApiUnauthorizedException(int errorCode, String message) {
        super(errorCode, message);
    }
}
