package com.exercise.backend.web.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.exercise.backend.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class for Customer.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UserModel implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonAlias("nombre")
    private String customerName;

    @JsonAlias("fecha_acceso")
    private LocalDateTime accessDate;

    /**
     * Constructor to map Customer entity to CustomerModel.
     * @param customer
     */
    public UserModel(User customer) {
        BeanUtils.copyProperties(customer, this);
    }
}
