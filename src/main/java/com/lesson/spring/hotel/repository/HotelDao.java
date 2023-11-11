package com.lesson.spring.hotel.repository;

import com.lesson.spring.hotel.domain.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> findAll();
}
