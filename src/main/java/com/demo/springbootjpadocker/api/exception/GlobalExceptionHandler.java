package com.demo.springbootjpadocker.api.exception;

import com.demo.springbootjpadocker.api.dto.ErrorDto;
import java.util.Calendar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity customerIsnotPresent(CustomerNotFoundException ex) {
        ErrorDto errorDto = new ErrorDto(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                ex.getMessage(),
                Calendar.getInstance());
        log.warn(ex.getMessage());
        return new ResponseEntity(errorDto, HttpStatus.NOT_FOUND);
    }
}
