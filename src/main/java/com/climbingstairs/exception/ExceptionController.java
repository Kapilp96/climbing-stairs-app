package com.climbingstairs.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(WrongInputs.class)
    public ResponseEntity<ErrorMessage> wrongInputs(WrongInputs ex, WebRequest request) {

        ErrorMessage.Result_body result_body = new ErrorMessage.Result_body();

        result_body.setTimestamp(new Date());
        result_body.setStatusCode(HttpStatus.BAD_REQUEST.value());
        result_body.setError(HttpStatus.BAD_REQUEST);
        result_body.setMessage(ex.getMessage());
        result_body.setPath("/stride");

        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.toString(),result_body
              );

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingInputs.class)
    public ResponseEntity<ErrorMessage> missingInputs(MissingInputs ex, WebRequest request) {

        ErrorMessage.Result_body result_body = new ErrorMessage.Result_body();

        result_body.setTimestamp(new Date());
        result_body.setStatusCode(HttpStatus.BAD_REQUEST.value());
        result_body.setError(HttpStatus.BAD_REQUEST);
        result_body.setMessage(ex.getMessage());
        result_body.setPath("/stride");

        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.toString(),result_body
        );

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ZeroRecordsException.class)
    public ResponseEntity<ErrorMessage> zeroRecordsException(ZeroRecordsException ex, WebRequest request) {

        ErrorMessage.Result_body result_body = new ErrorMessage.Result_body();

        result_body.setTimestamp(new Date());
        result_body.setStatusCode(HttpStatus.NO_CONTENT.value());
        result_body.setError(HttpStatus.NO_CONTENT);
        result_body.setMessage(ex.getMessage());
        result_body.setPath("/stride/request");

        ErrorMessage message = new ErrorMessage(
                HttpStatus.NO_CONTENT.toString(),result_body
        );

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NO_CONTENT);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage.Result_body result_body = new ErrorMessage.Result_body();

        result_body.setTimestamp(new Date());
        result_body.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result_body.setError(HttpStatus.INTERNAL_SERVER_ERROR);
        result_body.setMessage("INTERNAL_SERVER_ERROR");
        result_body.setPath("/stride");

        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),result_body
        );


        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
