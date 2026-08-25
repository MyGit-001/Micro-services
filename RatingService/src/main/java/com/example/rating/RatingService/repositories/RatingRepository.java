package com.example.rating.RatingService.repositories;

import com.example.rating.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.beans.JavaBean;
import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    //custom finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
