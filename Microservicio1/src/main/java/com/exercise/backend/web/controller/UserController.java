package com.exercise.backend.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.backend.service.UserService;
import com.exercise.backend.web.model.UserModel;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller for Biblioteca operations.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@RestController(value ="UserController")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService customerService;
    
    /**
     * Endpoint to save a customer.
     * @param customerName
     * @return
     */
    @PostMapping()
    public ResponseEntity<UserModel> save(@RequestBody UserModel customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer.getCustomerName()));
    }

    /**
     * Endpoint to get a customer by name.
     * @param customerName
     * @return
     */
    @GetMapping()
    public ResponseEntity<UserModel> getCustomerByName(@RequestParam("nombre") String customerName) {
        return ResponseEntity.ok(customerService.getCustomerByName(customerName));

    }

    @PostMapping("/get-out")
    public ResponseEntity<String> getOutUser(@RequestBody UserModel model) {
        return ResponseEntity.ok(customerService.getOutCustomerByName(model.getCustomerName()));
    }
    
    @GetMapping("/find-all")
    public ResponseEntity<List<UserModel>> getMethodName(@RequestHeader(value ="sleep", required = false) Boolean sleepBoolean) {
        return ResponseEntity.ok(customerService.getAllCustomers(sleepBoolean));
    }
    

}