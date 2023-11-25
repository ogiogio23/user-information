package com.ogiogio.api.exceptions;

import com.ogiogio.api.dto.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionAdvise {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleException(UserNotFoundException e){
        String []errorMsg = e.getMessage().split("\"");
        String error = errorMsg.length > 1 ? errorMsg[1] : e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getCode(), error));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseMessage> handleException(SQLIntegrityConstraintViolationException e){
        String []errorMsg = e.getMessage().split("\"");
        String error = errorMsg.length > 1 ? errorMsg[1] : e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getSQLState(), error));
    }
}
