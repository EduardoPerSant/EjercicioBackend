package com.exercise.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.backend.domain.entity.User;
import com.exercise.backend.domain.repository.UserRepository;
import com.exercise.backend.exception.BusinessException;
import com.exercise.backend.utils.Constants;
import com.exercise.backend.utils.ResponseCode;
import com.exercise.backend.utils.Utils;
import com.exercise.backend.web.model.UserModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * Service class for Biblioteca operations.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {
    
    private final UserRepository customerRepository;

    /**
     * Method to save a customer.
     * @param customerName
     * @return
     */
    public UserModel saveCustomer(String customerName) {

        log.info("Processing request with param: {}", customerName);
        if (!Utils.isAlphanumericWithSpecificSize(customerName, Constants.CUSTOMER_NAME_LENGTH)) {
            throw new BusinessException(ResponseCode.INVALID_CUSTOMER_NAME);
        }
        User existingCustomer = customerRepository.findByCustomerName(customerName);
        if (existingCustomer != null) {
            throw new BusinessException(ResponseCode.CUSTOMER_ALREADY_EXISTS);
        }

        List<User> customers = customerRepository.findAll();
        if (customers.size() >= Constants.CUSTOMER_LIMIT) {
            throw new BusinessException(ResponseCode.CUSTOMER_LIMIT_REACHED);
        }

        User customer = new User(customerName, LocalDateTime.now());
        User customerSaved = customerRepository.save(customer);
        UserModel customerModel = new UserModel(customerSaved);
        log.info("Customer saved successfully with id: {}", customerSaved.getId());
        return customerModel;

    }

    public UserModel getCustomerByName(String customerName) {
        log.info("Se consulta el cliente con nombre {}",customerName);
        User customer = customerRepository.findByCustomerName(customerName);

        if (customer != null) {
            return new UserModel(customer);
        }
        return null;
    }

    public List<User> getAllCustomers() {
        return customerRepository.findAll();
    }

    public String getOutCustomerByName(String customerName) {
        log.info("Se consulta el cliente con nombre {}",customerName);
        User customer = customerRepository.findByCustomerName(customerName);

        if (customer != null) {
             throw new BusinessException(ResponseCode.USER_NOT_FOUND);
        }
        return Constants.MESSAGE_USER_GET_OUT;
    }

}
