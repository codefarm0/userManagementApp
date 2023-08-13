package com.gl.userManagementApp.service;

import com.gl.userManagementApp.dto.User;
import com.gl.userManagementApp.expection.MandataoryParamNotPresentException;
import com.gl.userManagementApp.expection.ResourceAlreadyExistsIntheSystem;
import com.gl.userManagementApp.expection.UserNotFoundException;
import com.gl.userManagementApp.repository.UserRepository;
import com.gl.userManagementApp.repository.UserRepositoryUsingList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        Iterable<User> all = userRepository.findAll();
        List<User> users = new ArrayList<>();
        all.forEach(user -> users.add(user));
        return users;
    }


    public User getUser(Long id) {

        User user = userRepository.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("User not found for id - " + id);
        }
        return user;
    }


    public User addUser(User user) {
        validateUser(user);

//        user.setId(UUID.randomUUID().toString());

        userRepository.save(user);

        return user;
    }

    private void validateUser(User user) {
        if(user.getId() != null) {
            Optional<User> myUser = userRepository.findById(user.getId());
            if (myUser.isPresent()) {
                throw new ResourceAlreadyExistsIntheSystem("User with same id is already in the system");
            }
        }

        if (user.getName() == null) {
            throw new MandataoryParamNotPresentException("name shouldn't be null");
        }
        if (user.getAddress() == null) {
            throw new MandataoryParamNotPresentException("address shouldn't be null");
        }
    }


    public User updateUser(User user) {

        if(user== null || user.getId() == null){
            throw new RuntimeException("user should not be null");
        }
        if(userRepository.findById(user.getId()).isEmpty()){
            throw new UserNotFoundException("User to be updated is not present");
        }
        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("User to be deleted is not present");
        }
        userRepository.deleteById(id);
        return user.get();
    }
}
