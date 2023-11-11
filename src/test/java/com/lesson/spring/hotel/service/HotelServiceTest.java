package com.lesson.spring.hotel.service;

import com.lesson.spring.hotel.controller.dto.HotelRequestDto;
import com.lesson.spring.hotel.domain.Hotel;
import com.lesson.spring.hotel.repository.HotelDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @MockBean
    private HotelDao hotelDao;

    @Test
    void findAll() {
        //given
        List<Hotel> testHotels = List.of(
                Hotel.builder().owner("1").startDate(LocalDate.of(2023, 11, 10))
                        .endDate(LocalDate.of(2023, 11, 10)).build(),
                Hotel.builder().owner("2").startDate(LocalDate.of(2023, 11, 10))
                        .endDate(LocalDate.of(2023, 11, 10)).build(),
                Hotel.builder().owner("3").startDate(LocalDate.of(2023, 11, 10))
                        .endDate(LocalDate.of(2023, 11, 10)).build());

        when(hotelDao.findAll()).thenReturn(testHotels);
        //when
        List<Hotel> list = hotelService.findAll(new HotelRequestDto("2", LocalDate.of(2023,11,10)));

        //then
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getOwner()).isEqualTo("2");
    }
}