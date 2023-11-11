package com.lesson.spring.hotel.repository;

import com.lesson.spring.hotel.domain.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class HotelDaoImpl implements HotelDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Hotel> findAll() {
        jdbcTemplate.queryForObject("select * from hotel", Hotel.class);
        return null;
    }
}
