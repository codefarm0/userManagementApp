package com.gl.userManagementApp.controller;
import com.gl.userManagementApp.dto.User;
import com.gl.userManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User>getAllUser(){
        return userService.getAllUsers();

    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        User savedUser = userService.addUser(user);
        return savedUser;
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser( @PathVariable Long id){
        return userService.deleteUser(id);

    }


}
