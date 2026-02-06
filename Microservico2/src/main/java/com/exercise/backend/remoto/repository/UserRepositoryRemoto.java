package com.exercise.backend.remoto.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.exercise.backend.remoto.dto.UserDto;

/**
 * Repository interface for User operations via Feign Client.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@FeignClient(
    name = "microservicio-uno",
    url = "${microservicio-uno.uri}"
)
public interface UserRepositoryRemoto{

    @GetMapping(value = "/customer/find-all")
    List<UserDto> findAllCustomers(@RequestHeader Boolean sleep);
    
}
