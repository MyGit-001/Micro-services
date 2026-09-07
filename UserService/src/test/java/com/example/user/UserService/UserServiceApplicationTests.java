package com.example.user.UserService;

import com.example.user.UserService.entities.Rating;
import com.example.user.UserService.external.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
    private RatingService ratingService;

    @Test
    void createRating() {
        // Test code for creating a rating
        Rating rating = Rating.builder()
                .rating(9)
                .userId("user234")
                .hotelId("hotel234")
                .feedback("Test 2 Rating using Feign Client")
                .build();

        Rating newRating = ratingService.createRating(rating);
        System.out.println("Created Rating: " + newRating);
    }

//    @Test
//    void updateRating(){
//        Rating rating = Rating.builder()
//                .rating(10)
//                .userId("")
//                .hotelId("")
//                .feedback("Updated Test Rating using Feign Client")
//                .build();
//
//        Rating updatedRating = ratingService.updateRating("6a9d5de31f741609bb49b2d1", rating);
//        System.out.println("Updated Rating: " + updatedRating);
//    }


    @Test
    void deleteRating(){
        ratingService.deleteRating("6a9e8e7cb3c67e15b1735411");
        System.out.println("Deleted Rating");
    }
}
