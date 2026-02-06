package com.exercise.backend.remoto.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class for User.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDto{
    
    private Long id;

    @JsonAlias("nombre")
    private String customerName;
}
