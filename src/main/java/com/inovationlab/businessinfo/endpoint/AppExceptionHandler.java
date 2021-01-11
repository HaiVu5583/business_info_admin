package com.inovationlab.businessinfo.endpoint;


import com.inovationlab.businessinfo.exception.InvalidParamException;
import com.inovationlab.businessinfo.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = {AppExceptionHandler.class})
public class AppExceptionHandler {
    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<AppResponse> defaultExceptionHandler(HttpServletRequest req, Exception e) {
        AppResponse errorResponse = new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "unknown");
        return new ResponseEntity<AppResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<AppResponse> userNotFoundExceptionHandler(HttpServletRequest req, UserNotFoundException e) {
        AppResponse errorResponse = new AppResponse(HttpStatus.UNAUTHORIZED.value(), "invalid_user");
        return new ResponseEntity<AppResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    private ResponseEntity<AppResponse> getInvalidParamResponse(){
        AppResponse errorResponse = new AppResponse(HttpStatus.BAD_REQUEST.value(), "invalid_param");
        return new ResponseEntity<AppResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = InvalidParamException.class)
    public ResponseEntity<AppResponse> invalidParamExceptionHandler(HttpServletRequest req, InvalidParamException e) {
        return getInvalidParamResponse();
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<AppResponse> invalidParamExceptionHandler(HttpServletRequest req, MethodArgumentTypeMismatchException e) {
        return getInvalidParamResponse();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<AppResponse> invalidParamExceptionHandler(HttpServletRequest req, IllegalArgumentException e) {
        return getInvalidParamResponse();
    }

}
