package com.geofence.exception;

public class DataInsertionException extends RuntimeException {
    private String message;

    public DataInsertionException(String message) {
        this.message = message;
    }
}
