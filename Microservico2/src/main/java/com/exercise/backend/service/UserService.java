package com.exercise.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.backend.remoto.dto.UserDto;
import com.exercise.backend.remoto.service.UserServiceRemoto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserServiceRemoto userServiceRemoto;

    /**
     * Method to get all users from remote microservice.
     * @return List<UserDto>
     */
    public List<UserDto> getAllUsers(Boolean sleep) {
        Boolean sleepBoolean = Boolean.FALSE;
        if (Boolean.TRUE.equals(sleep)) {
            sleepBoolean = Boolean.TRUE;
        }
        return userServiceRemoto.getAllUsers(sleepBoolean);
    }
}
