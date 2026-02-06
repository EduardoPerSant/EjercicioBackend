package com.exercise.backend.utils;

/**
 * Response codes used in the application.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
public enum ResponseCode {

    INVALID_CUSTOMER_NAME("422", "El nombre del cliente no cumple con las reglas de validación.", "Error"),
    UNAUTHORIZED("401", "Unauthorized access.", "Error"),
    CUSTOMER_ALREADY_EXISTS("409", "El cliente ya esta dentro de la Biblioteca.", "Error"),
    CUSTOMER_LIMIT_REACHED("401", "Se ha alcanzado el límite de clientes en la Biblioteca.", "Error"),
    USER_NOT_FOUND("404", "El usuario no se encuentra en la Biblioteca.", "Error");

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
