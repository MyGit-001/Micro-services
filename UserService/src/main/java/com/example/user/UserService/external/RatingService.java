package com.example.user.UserService.external;

import com.example.user.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "RatingService")
public interface RatingService {
    //Get

    //Post
    @PostMapping("/ratings")
    public Rating createRating(@RequestBody Rating rating);

    //put
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId,@RequestBody Rating rating);

    //Delete
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);
}
