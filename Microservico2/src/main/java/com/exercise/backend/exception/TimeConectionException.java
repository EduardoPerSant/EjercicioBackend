package com.exercise.backend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.exercise.backend.utils.ResponseCode;

import lombok.Getter;

/**
 * Custom exception class for business logic errors.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@Getter
@ResponseStatus
public class TimeConectionException extends RuntimeException{

    public static final long serialVersionUID = 1L;
    private final String code;
    private final String type;
    private final String details;

    public TimeConectionException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.type = responseCode.getType();
        this.details = responseCode.getMessage();
    }

}
