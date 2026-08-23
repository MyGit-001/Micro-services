package com.example.user.UserService.controllers;

import com.example.user.UserService.entities.User;
import com.example.user.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        //return ResponseEntity.status(HttpStatus.CREATED).body(user1);
        return ResponseEntity.status(201).body(user1);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user= userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //get all user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers = userService.getAllUser();
        return ResponseEntity.ok(allUsers);
    }




}
