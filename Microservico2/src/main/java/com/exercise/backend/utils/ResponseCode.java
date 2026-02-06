package com.exercise.backend.utils;

/**
 * Response codes used in the application.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
public enum ResponseCode {

    TIME_CONNECTION_ERROR("400", "El MS 1 tardo mas de lo esperado", "Error");
    
    private final String code;
    private final String message;
    private final String type;


    ResponseCode(String code, String message, String type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
