package com.exercise.backend.utils;

import lombok.NoArgsConstructor;

/**
 * Constants class for common constant values.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 *  @version: 1.0.0
 */
@NoArgsConstructor
public class Constants {

    public final static Integer CUSTOMER_NAME_LENGTH = 8;
    public final static Integer CUSTOMER_LIMIT = 10;
    public final static String MESSAGE_USER_GET_OUT = "El usuario ha salido de la Biblioteca exitosamente.";

    public final static String REGEX_STRING_ALPHANUMERIC = "^(?=.*[A-Za-z])(?=.*\\d).+$";

    public final static Integer SECONDS_TO_SLEEP = 8; // segundos
}
