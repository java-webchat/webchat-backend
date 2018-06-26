package com.aichat.common;

import com.aichat.exception.ApiErrorEnum;
import com.google.common.base.Strings;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private static final String OK = "";
    private static final String ERROR = "error";
    private boolean success;
    private int code;
    private String message;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Response<T> code(int code) {
        this.code = code;
        return this;
    }

    public Response<T> success() {
        final Response<T> code = code(0);
        code.setSuccess(true);

        return code;
    }

    public Response<T> failure() {
        this.success = false;
        this.message = ERROR;
        return this;
    }

    public Response<T> success(String message) {
        return success(message, null);
    }

    public Response<T> success(String message, T data) {

        if (Strings.isNullOrEmpty(message)) {
            message = OK;
        }

        final Response<T> response = success()
                .success()
                .message(message).data(data);
        return response;
    }


    public Response<T> error(int errCode) {
        return error(errCode, "", null);
    }

    public Response<T> error(int errCode, String message) {
        return error(errCode, message, null);
    }

    public Response<T> error(int errCode, String message, T data) {
        if (errCode == 0) {
            throw new IllegalArgumentException("code不能等于0");
        }

        if (Strings.isNullOrEmpty(message)) {
            message = ERROR;
        }

        final Response<T> response = new Response<T>()
                .failure()
                .code(errCode).message(message).data(data);
        return response;
    }

    public Response<T> error(ApiErrorEnum responseErrorEnum) {
        return error(responseErrorEnum.getCode(), responseErrorEnum.getMessage());
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response<T> message(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response<T> data(T data) {
        this.data = data;
        return this;
    }

    public static <T> Response<T> newInstance() {
        return new Response<T>();
    }
    //TODO 便利方法 builder
}
