package com.example.user.UserService.services.Impl;

import com.example.user.UserService.entities.Rating;
import com.example.user.UserService.entities.User;
import com.example.user.UserService.exceptions.ResourceNotFoundException;
import com.example.user.UserService.repositories.UserRepository;
import com.example.user.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //create a unique user id for new User
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
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with given ID"));

        //fetch rating of the above user from RATING-SERVICE
        //http://localhost:8083/ratings/users/1bef926f-62f7-4cd7-9119-e242092dda95

        ArrayList<Rating> ratingOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
        logger.info("Response from RATING-SERVICE: {}", ratingOfUser);

        user.setRatings(ratingOfUser);
        return user;
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
