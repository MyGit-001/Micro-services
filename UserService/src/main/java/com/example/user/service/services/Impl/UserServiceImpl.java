package com.example.user.service.services.Impl;

import com.example.user.service.entities.User;
import com.example.user.service.exceptions.ResourceNotFoundException;
import com.example.user.service.repositories.UserRepository;
import com.example.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        //create a unique user Id for new User
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with given ID"));
    }

    @Override
    public Void deleteUser(String userId) {
        return null;
    }

    @Override
    public String updateUser(User user, String userId) {
        return "";
    }
}
