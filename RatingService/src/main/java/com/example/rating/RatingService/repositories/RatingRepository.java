package com.example.rating.RatingService.repositories;

import com.example.rating.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.beans.JavaBean;

public interface RatingRepository extends MongoRepository<Rating, String> {

}
