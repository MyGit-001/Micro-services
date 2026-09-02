package com.example.user.UserService.services.Impl;

import com.example.user.UserService.entities.Hotel;
import com.example.user.UserService.entities.Rating;
import com.example.user.UserService.entities.User;
import com.example.user.UserService.exceptions.ResourceNotFoundException;
import com.example.user.UserService.external.HotelService;
import com.example.user.UserService.repositories.UserRepository;
import com.example.user.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

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

        Rating[] ratingOfUser = restTemplate.getForObject(
                "http://localhost:8083/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("Response from RATING-SERVICE: {}", ratingOfUser);

        //converting Array to List
        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/bb7abba5-2378-497a-8ff4-5886c646f007

            System.out.println("rating.getHotelId()");
            ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity(
                    "http://HotelService/hotels/"+rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelResponseEntity.getBody();
            logger.info("Response status code: {}", hotelResponseEntity.getStatusCode());

            //Using Feign Client to call Hotel Service
            //Hotel hotel = hotelService.getHotel(rating.getHotelId());

            //set the hotel to rating
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
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
