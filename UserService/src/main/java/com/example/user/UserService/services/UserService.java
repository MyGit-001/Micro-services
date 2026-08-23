package com.example.user.UserService.services;

import com.example.user.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
