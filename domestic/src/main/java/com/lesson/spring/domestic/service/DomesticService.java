package com.lesson.spring.domestic.service;

import com.lesson.spring.core.domain.Hotel;
import com.lesson.spring.core.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DomesticService {

    private final HotelRepository hotelRepository;

    public Hotel hotel() {
        Optional<Hotel> byId = hotelRepository.findById(1L);
        return byId.orElse(null);
    }

}
