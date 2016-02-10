package dk.mhr.controller;

import dk.mhr.exception.DateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Morten on 05-12-2015.
 * Advice Class for handling general Exceptions
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(DateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String exception(Exception e) {
        return e.getMessage();
    }
}
