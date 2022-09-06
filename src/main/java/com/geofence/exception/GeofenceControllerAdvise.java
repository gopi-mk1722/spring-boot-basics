package com.geofence.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeofenceControllerAdvise {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorMessage> noDataFoundException(NoDataFoundException ex){
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(DataInsertionException.class)
    public ResponseEntity<ErrorMessage> dataInsertionException(DataInsertionException ex){
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
