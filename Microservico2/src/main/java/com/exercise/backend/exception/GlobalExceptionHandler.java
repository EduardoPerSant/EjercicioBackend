package com.exercise.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exercise.backend.dto.ApiResponseDto;
import com.exercise.backend.utils.ResponseCode;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

import java.time.Instant;


@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler(TimeConectionException.class)
    public ResponseEntity<ApiResponseDto> handleBusinessException(TimeConectionException ex, WebRequest request) {
        return buildResponse(ex.getCode(),
         ex.getType(),
         ex.getDetails(),
         HttpStatus.GATEWAY_TIMEOUT);
    }  

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto> handleGeneralException(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        return buildResponse(ResponseCode.TIME_CONNECTION_ERROR.getCode(),
         ResponseCode.TIME_CONNECTION_ERROR.getType(),
          ResponseCode.TIME_CONNECTION_ERROR.getMessage(),
           HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiResponseDto> buildResponse(String code, String type, String details, HttpStatus status) {
        ApiResponseDto responseDto = new ApiResponseDto(
            code,
            type,
            Instant.now().toString(),
            details
        );
        return ResponseEntity.status(status).body(responseDto);
    }
}