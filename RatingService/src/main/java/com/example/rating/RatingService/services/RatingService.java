package com.example.rating.RatingService.services;

import com.example.rating.RatingService.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    // create
    Rating create(Rating rating);

    // get all ratings
    List<Rating> getRatings();

    // get single rating
    //Rating get(String ratingId);

    // get all ratings by userId
    List<Rating> getRatingByUserId(String userId);

    // get all ratings by hotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
