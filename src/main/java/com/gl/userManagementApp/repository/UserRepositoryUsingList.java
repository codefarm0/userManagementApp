package com.gl.userManagementApp.repository;

import com.gl.userManagementApp.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@Repository
public class UserRepositoryUsingList {

    List<User> userList= new ArrayList<>();
    public List<User> getAllUsers() {
        return userList;
    }

    public User getUser(String id) {
        System.out.println("getting user for id-" + id);
        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if(first.isPresent()){
            return first.get();
        }else{
           return null;
        }
    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    public User updateUser(User user) {
        for(User u1 :userList){
            if(u1.getId().equals(user.getId())){
                u1.setName(user.getName());
                u1.setAddress(user.getAddress());
                return u1;
            }
        }
        return null;
    }

    public User deleteUser(String id) {
        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if(first.isPresent()){
            User user = first.get();
            userList.remove(user);
            return user;
        }else{
            return null;
        }


    }
}
