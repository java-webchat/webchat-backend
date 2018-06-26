package com.aichat.exception;

import com.aichat.common.Response;
import com.aichat.common.ResponseGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class ApiExceptionHandlerAdvice {

    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    /**
     * Bean 校验.
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response exception(BindException exception, WebRequest request) {
        logger.warn("BAD_REQUEST",exception);
        return
                ResponseGenerator.genResult(ApiErrorEnum.Request.InvalidArguments.getCode(),
                        exception.getFieldError().getDefaultMessage(),
                        exception.getFieldErrors());
    }

    /**
     * Bean校验.
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response exception(MethodArgumentNotValidException exception, WebRequest request) {
        logger.warn("BAD_REQUEST",exception);
        return ResponseGenerator.genResult(ApiErrorEnum.Request.InvalidArguments.getCode(),
                exception.getBindingResult().getFieldError().getDefaultMessage(),
                exception.getBindingResult().getFieldErrors());
    }

    /**
     * Handle API HttpRequestMethodNotSupportedException thrown by handlers.
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response exception(HttpRequestMethodNotSupportedException exception, WebRequest request) {
        logger.warn("BAD_REQUEST",exception);
        return ResponseGenerator.genErrorResult(ApiErrorEnum.Request.MethodNotSupported);
    }

    /**
     * Handle API TypeMismatchException thrown by handlers.
     */
    @ExceptionHandler(value = TypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response exception(TypeMismatchException exception, WebRequest request) {
        logger.warn("BAD_REQUEST",exception);
        return ResponseGenerator.genErrorResult(ApiErrorEnum.Request.InvalidArguments.getCode()
                , exception.getMessage());
    }

    /**
     * Handle API MissingServletRequestParameterException thrown by handlers.
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response exception(MissingServletRequestParameterException exception, WebRequest request) {
        logger.warn("BAD_REQUEST",exception);
        return ResponseGenerator.genErrorResult(ApiErrorEnum.Request.MissingRequiredArguments.getCode(),
                exception.getMessage());
    }


    /**
     * Handle API ApiUnauthorizedException thrown by handlers.
     */
    @ExceptionHandler(value = ApiUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Response exception(ApiUnauthorizedException exception, WebRequest request) {
        logger.warn("UNAUTHORIZED",exception);
        return ResponseGenerator.genErrorResult(ApiErrorEnum.Request.Unauthorized);
    }

    /**
     * Handle ApiException thrown by handlers.
     */
    @ExceptionHandler(value = ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response exception(ApiException exception, WebRequest request) {

        logger.error("BAD_REQUEST",exception);
        return ResponseGenerator.genErrorResult(exception);
    }

    /**
     * 系统内部错误 Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response exception(Exception exception, WebRequest request) {

        Map<String, Object> data = this.getExceptionData(exception);
        logger.error("INTERNAL_SERVER_ERROR",exception);

        return ResponseGenerator.genErrorResult(ApiErrorEnum.Internal.ServiceError, data);
    }

//    /**
//     * BetaException 错误 Handle exceptions thrown by handlers.
//     */
//    @ExceptionHandler(value = BetaException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Response exception(BetaException exception, WebRequest request) {
//
//        logger.warn("BetaException", exception);
//
//        Map<String, Object> data = this.getExceptionData(exception);
//
//        return ResponseGenerator.genErrorResult(ApiErrorEnum.Internal.ServiceError, data);
//    }


    /**
     * BetaRuntimeException 错误 Handle exceptions thrown by handlers.
     */


    /**
     * 参数错误.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private Response exception(IllegalArgumentException e) {

        logger.error("--------->接口调用异常!", e);
        return ResponseGenerator.genErrorResult(ApiErrorEnum.Request.InvalidArguments);
    }




    private Map<String, Object> getExceptionData(Exception exception) {
        Map<String, Object> data = new HashMap<String, Object>();
        Object firstStackTrace = Array.get(exception.getStackTrace(), 0);
        data.put("service_message", exception.getMessage());
        data.put("first_stack_trace", firstStackTrace);

        logger.error("api_internal_error:", exception);

        return data;
    }
}
