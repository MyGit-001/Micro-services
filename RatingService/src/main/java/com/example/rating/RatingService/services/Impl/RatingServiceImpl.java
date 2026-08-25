package com.example.rating.RatingService.services.Impl;

import com.example.rating.RatingService.entities.Rating;
import com.example.rating.RatingService.services.RatingService;

import java.util.List;

public class RatingServiceImpl implements RatingService {
    @Override
    public Rating create(Rating rating) {
        return null;
    }

    @Override
    public List<Rating> getRatings() {
        return List.of();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return List.of();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return List.of();
    }
}
