package com.example.user.service.services;

import com.example.user.service.entities.User;

import java.util.List;

public interface UserService {

    //create
    User saveUser(User user);
    //get All User
    List<User> getAllUser();
    //get Single User
    User getUser(String userId);

    Void deleteUser(String userId);

    String updateUser(User user , String userId);
}
