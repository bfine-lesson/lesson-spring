package com.lesson.spring.hotel.service;

import com.lesson.spring.hotel.api.dto.ApiRequestDto;
import com.lesson.spring.hotel.dao.HotelDao;
import com.lesson.spring.hotel.dao.HotelDaoImpl;
import com.lesson.spring.hotel.domain.Hotel;
import com.lesson.spring.hotel.service.dto.HotelServiceResponseDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final HotelDao hotelDao;

    public HotelService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    public List<HotelServiceResponseDto> getHotels(ApiRequestDto apiRequestDto) {
        LocalDate availableDate = apiRequestDto.getAvailableDate();
        List<Hotel> hotels = hotelDao.getHotels();
        List<HotelServiceResponseDto> ownerList = new ArrayList<>();
        // db -> 모든 가능한 호텔 날짜를 가져온다 -> 서비스 로직 처리(가능한 날짜로)

        for (Hotel hotel : hotels) {
            LocalDate startDate = hotel.getStartDate();
            LocalDate endDate = hotel.getEndDate();
            String owner = hotel.getOwner();

            if ((startDate.isBefore(availableDate) && endDate.isAfter(availableDate) || startDate.equals(availableDate))
                    && owner.equals(apiRequestDto.getOwner())) {
                ownerList.add(HotelServiceResponseDto.of(hotel));
            }
        }

        return ownerList;
    }

    public void saveHotel() {

    }

    public void updateHotel() {
    }

    public void deleteHotel() {

    }


}
