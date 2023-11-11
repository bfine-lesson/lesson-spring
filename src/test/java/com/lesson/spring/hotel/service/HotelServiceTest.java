package com.lesson.spring.hotel.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.lesson.spring.hotel.api.dto.ApiRequestDto;
import com.lesson.spring.hotel.dao.HotelDao;
import com.lesson.spring.hotel.dao.HotelDaoImpl;
import com.lesson.spring.hotel.domain.Hotel;
import com.lesson.spring.hotel.service.dto.HotelServiceResponseDto;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @MockBean
    private HotelDao hotelDao;

    @DisplayName("특정일자에 사용가능한 사장님의 호텔리스트를 추출한다.")
    @Test
    void getHotels() {
        //given
        List<Hotel> testHotels = List.of(
                Hotel.builder().owner("동욱").startDate(LocalDate.of(2022, 11, 10))
                        .endDate(LocalDate.of(2022, 11, 10)).build(),
                Hotel.builder().owner("욱동").startDate(LocalDate.of(2022, 11, 10))
                        .endDate(LocalDate.of(2022, 11, 10)).build(),
                Hotel.builder().owner("동욱").startDate(LocalDate.of(2022, 11, 10))
                        .endDate(LocalDate.of(2022, 11, 10)).build());
        ApiRequestDto apiRequestDto = new ApiRequestDto("동욱", LocalDate.of(2022, 11, 10));
        when(hotelDao.getHotels()).thenReturn(testHotels);

        //when
        List<HotelServiceResponseDto> hotels = hotelService.getHotels(apiRequestDto);

        //then
        assertEquals(hotels.size(), 2);
        for (HotelServiceResponseDto hotel : hotels) {
            assertEquals(hotel.getOwner(), "동욱");
        }
    }
}