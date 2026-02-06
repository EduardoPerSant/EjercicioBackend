package com.exercise.backend.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    public static Boolean isAlphanumericWithSpecificSize(String str, Integer size) {
        return str != null && str.matches(Constants.REGEX_STRING_ALPHANUMERIC) && str.length() == size;
    }

    /**
     * Method to sleep the thread for a specific time defined in Constants.
     * This method uses a Timer to schedule a task after the specified time, simulating a delay in processing.
     */
    public static void sleepByTime(Integer timeToSleep) {
        
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        try {
            scheduler.schedule(() -> {
            }, timeToSleep, TimeUnit.SECONDS).get(); //
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Hilo interrumpido durante la espera", e);
        } catch (ExecutionException e) {
            throw new IllegalStateException("Error al esperar el tiempo programado", e);
        } finally {
            scheduler.shutdown();
        }
    }
}
