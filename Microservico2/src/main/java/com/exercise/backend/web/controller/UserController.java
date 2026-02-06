package com.exercise.backend.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.backend.remoto.dto.UserDto;
import com.exercise.backend.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * Controller for User operations.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@RestController(value ="UserController")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    /**
     * Endpoint to get all users.
     * @return List<UserDto>
     */
    @GetMapping("/find-all")
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestHeader(value ="sleep", required = false) Boolean sleepBoolean) {
        return ResponseEntity.ok(userService.getAllUsers(sleepBoolean));
    }
}
