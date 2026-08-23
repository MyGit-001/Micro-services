package com.example.Hotel.HotelService.services;

import com.example.Hotel.HotelService.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    //create
    Hotel create(Hotel hotel);

    //get single
    Hotel getHotel(String id);

    //get All
    List<Hotel> getAll();
}
