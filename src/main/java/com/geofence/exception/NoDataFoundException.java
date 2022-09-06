package com.geofence.exception;

public class NoDataFoundException extends RuntimeException{
    String message;

    public NoDataFoundException(String message) {
        super(message);
    }
}
