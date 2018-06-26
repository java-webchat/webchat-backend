package com.aichat.common;


import com.aichat.exception.ApiErrorEnum;
import com.aichat.exception.ApiException;

/**
 * 统一的RestController结果生成器
 */
public class ResponseGenerator {

    /**
     * 生成相应成功的结果.
     */
    public static Response genResult() {
        return genResult(null, null);
    }


    /**
     * 生成响应成功的(不带DATA)的结果
     *
     * @param message 成功提示信息
     * @return ResponseResult
     */
    public static Response genResult(String message) {
        return genResult(message, null);
    }


    /**
     * 生成响应成功(只带DATA)的结果
     *
     * @param data 结果DATA
     * @return ResponseResult<T>
     */
    public static <T> Response<T> genResult(T data) {
        return genResult(null, data);
    }


    /**
     * 生成响应成功(带DATA)的结果
     *
     * @param data    结果DATA
     * @param message 成功提示信息
     * @return ResponseResult<T>
     */
    public static <T> Response<T> genResult(String message, T data) {

        Response<T> result = Response.newInstance();
        return result.success(message, data);
    }


    /**
     * 生成自定义响应.
     */
    public static <T> Response<T> genResult(int code, String message, T data) {
        final Response<T> result = Response.newInstance();

        return result.code(code).message(message).data(data);
    }


    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    public static Response genErrorResult(ApiErrorEnum responseErrorEnum) {

        Response result = Response.newInstance();
        return result.error(responseErrorEnum);
    }

    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    public static Response genErrorResult(ApiErrorEnum responseErrorEnum, String message) {

        Response result = Response.newInstance();
        final Response error = result.error(responseErrorEnum);
        return error.message(message);
    }


    public static Response genErrorResult(ApiException apiEx) {
        return Response.newInstance().code(apiEx.getCode()).data(apiEx.getData()).message(apiEx.getMessage());
    }

    public static Response genErrorResult(int code, String message) {
        return genResult(code, message, null);
    }

    public static Response genErrorResult(ApiErrorEnum apiErrorEnum, Object data) {
        final Response response = genErrorResult(apiErrorEnum);

        response.setData(data);

        return response;
    }
}
