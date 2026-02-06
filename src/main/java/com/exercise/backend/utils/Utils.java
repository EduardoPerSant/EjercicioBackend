package com.exercise.backend.utils;

import lombok.NoArgsConstructor;

/**
 * Utility class for common methods.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@NoArgsConstructor
public class Utils {

    /**
     * Method to validate if a string is alphanumeric and has exactly 8 characters.
     * @param str
     * @return
     */
    public static boolean isAlphanumericWithSpecificSize(String str, Integer size) {
        return str != null && str.matches("^(?=.*[A-Za-z])(?=.*\\d).+$") && str.length() == size;
    }
}
