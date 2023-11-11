package com.lesson.spring.hotel.service;

import com.lesson.spring.hotel.controller.dto.HotelRequestDto;
import com.lesson.spring.hotel.domain.Hotel;
import com.lesson.spring.hotel.repository.HotelDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HotelService {

    private final HotelDao hotelDao;

    public List<Hotel> findAll(HotelRequestDto requestDto) {
        List<Hotel> hotels = hotelDao.findAll();
        List<Hotel> result = new ArrayList<>();
        for (Hotel h : hotels) {
            if (h.getOwner().equals(requestDto.getOwner())
                    && (h.getStartDate().isAfter(requestDto.getDate()) || h.getStartDate().isEqual(requestDto.getDate()))
                    && (h.getEndDate().isBefore(requestDto.getDate()) || h.getEndDate().isEqual(requestDto.getDate()))) {
                result.add(h);
            }
        }

        return result;
    }
}
