package com.exercise.backend.dto;

import lombok.Getter;

@Getter
public class ApiResponseDto {
    private final String code;
    private final String type;
    private final String timestamp;
    private final String details;
    public ApiResponseDto(String code, String type, String timestamp, String details) {
        this.code = code;
        this.type = type;
        this.timestamp = timestamp;
        this.details = details;
    }
}
