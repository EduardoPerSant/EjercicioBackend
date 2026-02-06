package com.exercise.backend.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.exercise.backend.domain.entity.User;
import com.exercise.backend.domain.repository.UserRepository;
import com.exercise.backend.exception.BusinessException;
import com.exercise.backend.service.UserService;
import com.exercise.backend.utils.Constants;

import com.exercise.backend.web.model.UserModel;



@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;
    String customerName;
    @BeforeEach
    void setUp() {
        customerName = "abcdefg1";
        testUser = new User("testuser", LocalDateTime.now());
    }

    @Test
    void testSaveCustomerSuccess() {
        when(userRepository.findByCustomerName(customerName)).thenReturn(null);
        when(userRepository.findAll()).thenReturn(Arrays.asList());
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        UserModel result = userService.saveCustomer(customerName);

        assertNotNull(result);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testSaveCustomerInvalidName() {
        assertThrows(BusinessException.class, () -> userService.saveCustomer(""));
    }

    @Test
    void testSaveCustomerAlreadyExists() {
        when(userRepository.findByCustomerName(customerName)).thenReturn(testUser);

        assertThrows(BusinessException.class, () -> userService.saveCustomer(customerName));
    }

    @Test
    void testSaveCustomerLimitReached() {
        List<User> customers = new ArrayList<>();
        for(int i = 0; i < Constants.CUSTOMER_LIMIT; i++) {
            customers.add(testUser);
        }
        when(userRepository.findByCustomerName(customerName)).thenReturn(null);
        when(userRepository.findAll()).thenReturn(customers);

        assertThrows(BusinessException.class, () -> userService.saveCustomer(customerName));
    }

    @Test
    void testGetCustomerByNameSuccess() {
        when(userRepository.findByCustomerName(customerName)).thenReturn(testUser);

        UserModel result = userService.getCustomerByName(customerName);

        assertNotNull(result);
        verify(userRepository).findByCustomerName(customerName);
    }

    @Test
    void testGetCustomerByNameNotFound() {
        when(userRepository.findByCustomerName(customerName)).thenReturn(null);

        UserModel result = userService.getCustomerByName(customerName);

        assertNull(result);
    }

    @Test
    void testGetAllCustomers() {
        List<User> customers = Arrays.asList(testUser, testUser);
        when(userRepository.findAll()).thenReturn(customers);

        List<UserModel> result = userService.getAllCustomers(false);

        assertEquals(2, result.size());
        verify(userRepository).findAll();
    }

    @Test
    void testGetOutCustomerByNameNotFound() {
        when(userRepository.findByCustomerName(customerName)).thenReturn(null);
        assertThrows(BusinessException.class, () -> userService.getOutCustomerByName(customerName));
    }

    @Test
    void testGetOutCustomerByNameExists() {
        when(userRepository.findByCustomerName(customerName)).thenReturn(testUser);
        String result = userService.getOutCustomerByName(customerName);
        assertEquals(Constants.MESSAGE_USER_GET_OUT, result);
    }


}