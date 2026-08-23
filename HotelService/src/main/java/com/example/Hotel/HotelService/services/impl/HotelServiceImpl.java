package com.example.Hotel.HotelService.services.impl;

import com.example.Hotel.HotelService.entities.Hotel;
import com.example.Hotel.HotelService.exceptions.ResourceNotFoundException;
import com.example.Hotel.HotelService.repository.HotelRepository;
import com.example.Hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Hotel Not found By ID")
        );
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
