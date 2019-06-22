package com.example.dockerizedsample.services;

import com.example.dockerizedsample.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveUser(User newUser);
    void deleteUserByEmail(String email);
    User findByEmail(String email);
}
