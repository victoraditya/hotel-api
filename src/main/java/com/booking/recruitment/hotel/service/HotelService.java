package com.booking.recruitment.hotel.service;

import com.booking.recruitment.hotel.model.Hotel;

import java.util.List;

public interface HotelService {
  List<Hotel> getAllHotels();

  Hotel getHotelById(Long hotelId);

  List<Hotel> searchNearestHotel(Long cityId, String sortBy);

  void deleteHotelById(Long hotelId);

  List<Hotel> getHotelsByCity(Long cityId);

  Hotel createNewHotel(Hotel hotel);
}
