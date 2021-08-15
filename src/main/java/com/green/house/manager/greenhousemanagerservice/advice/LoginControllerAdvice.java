package com.green.house.manager.greenhousemanagerservice.advice;

import com.green.house.manager.greenhousemanagerservice.controller.CommandController;
import com.green.house.manager.greenhousemanagerservice.controller.ReadingController;
import com.green.house.manager.greenhousemanagerservice.exception.NoRecordFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice(assignableTypes = {ReadingController.class, CommandController.class})
public class LoginControllerAdvice {
	
	@ExceptionHandler(value = {NoRecordFoundException.class})
    public ResponseEntity<Object> handleCacheException(NoRecordFoundException ex) {
        log.error("user login exception: ", ex.getMessage());
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleArgumentMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("Invalid types: ", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
