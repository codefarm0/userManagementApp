package com.gl.userManagementApp.expection.handler;

import com.gl.userManagementApp.dto.APIError;
import com.gl.userManagementApp.expection.MandataoryParamNotPresentException;
import com.gl.userManagementApp.expection.ResourceAlreadyExistsIntheSystem;
import com.gl.userManagementApp.expection.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({MandataoryParamNotPresentException.class, ResourceAlreadyExistsIntheSystem.class})
    ResponseEntity<?> customExpcetionHandler(Exception exc, ServletWebRequest request) {

        APIError apiError = new APIError();

        apiError.setTimeStamp(LocalDateTime.now());
        apiError.setPathUri(request.getDescription(false));
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setErrors(Arrays.asList(exc.getMessage()));

        return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({UserNotFoundException.class})
    ResponseEntity<?> NotFoundExpcetionHandler(Exception exc, ServletWebRequest request) {

        APIError apiError = new APIError();

        apiError.setTimeStamp(LocalDateTime.now());
        apiError.setPathUri(request.getDescription(false));
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setErrors(Arrays.asList(exc.getMessage()));

        return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
