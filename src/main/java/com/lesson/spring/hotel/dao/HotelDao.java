package com.lesson.spring.hotel.dao;

import com.lesson.spring.hotel.domain.Hotel;
import java.util.List;

public interface HotelDao {

    List<Hotel> getHotels();

    void saveHotel();

    void updateHotel();

    void deleteHotel();


}
