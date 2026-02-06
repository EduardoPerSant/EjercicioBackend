package com.exercise.backend.domain.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exercise.backend.domain.entity.User;

/**
 * Repository interface for Customer entity.
 * @author: Eduardo Pérez
 * @since: 2024-06-15
 * @version: 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findByCustomerName(String customerName);

    public List<User> findAll();
}
