package com.exercise.backend.remoto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.backend.exception.TimeConectionException;
import com.exercise.backend.remoto.dto.UserDto;
import com.exercise.backend.remoto.repository.UserRepositoryRemoto;
import com.exercise.backend.utils.ResponseCode;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.log4j.Log4j2;

/**
 * Service class for User operations via remote microservice.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 *  @version: 1.0.0
 */
@Service
@Log4j2
public class UserServiceRemoto {

    private final UserRepositoryRemoto userRepositoryRemoto;

    public UserServiceRemoto(UserRepositoryRemoto userRepositoryRemoto) {
        this.userRepositoryRemoto = userRepositoryRemoto;
    }

    /**
     * Method to get all users from remote microservice.
     * @return List<UserDto>
     */
    @CircuitBreaker( fallbackMethod = "getAllUsersFallback", name = "userService")
    @TimeLimiter(name = "userService")
    public List<UserDto> getAllUsers(Boolean sleep) {   
        log.info("Fetching all users from remote microservice");
        return userRepositoryRemoto.findAllCustomers(sleep);
    }

    /**
     * Fallback method for getAllUsers in case of failure.
     * @return List<UserDto>
     */
public List<UserDto> getAllUsersFallback(Boolean sleep, Throwable ex) {
    log.error("Timeout o error llamando al microservicio: {}", ex.getMessage(), ex);
    throw new TimeConectionException(ResponseCode.TIME_CONNECTION_ERROR);
}

}
