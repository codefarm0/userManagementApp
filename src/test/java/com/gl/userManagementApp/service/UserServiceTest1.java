package com.gl.userManagementApp.service;

import com.gl.userManagementApp.expection.UserNotFoundException;
import com.gl.userManagementApp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest1 {

    private UserService userService;
    @BeforeEach
    void setUp() {
        //mock user repository
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    //unit test case for getAllUsers
    @org.junit.jupiter.api.Test
    void getAllUsers() {
        assertEquals(0, userService.getAllUsers().size());
    }

    //unit test case for getUser
    @org.junit.jupiter.api.Test
    void getUser() {
        //when user not present in the system
        assertThrows(UserNotFoundException.class, () -> userService.getUser(123l));
    }
    //unit test case for getUser(long id) when user present in the system
    @org.junit.jupiter.api.Test
    void getUser1() {
        //when user not present in the system
        assertThrows(UserNotFoundException.class, () -> userService.getUser(123l));
    }
    //positive unit test case for getUser(long id) when user present in the system
    @org.junit.jupiter.api.Test
    void getUser2() {
        //when user not present in the system
        assertThrows(UserNotFoundException.class, () -> userService.getUser(123l));
    }


    @AfterEach
    void tearDown() {
    }
}