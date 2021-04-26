package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Hotel> getAllHotels() {
    return hotelService.getAllHotels();
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Hotel getHotelById(@PathVariable Long id) {
    return hotelService.getHotelById(id);
  }

  @GetMapping("search/{cityId}")
  @ResponseStatus(HttpStatus.OK)
  public List<Hotel> searchNearestHotel(@PathVariable Long cityId, @RequestParam("sortBy") String sortBy) {
    return hotelService.searchNearestHotel(cityId, sortBy);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteHotelById(@PathVariable Long id) {
       hotelService.deleteHotelById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Hotel createHotel(@RequestBody Hotel hotel) {
    return hotelService.createNewHotel(hotel);
  }
}
