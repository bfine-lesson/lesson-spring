package com.lesson.spring.hotel.dao;

import com.lesson.spring.hotel.domain.Hotel;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl implements HotelDao{

    private final JdbcTemplate jdbcTemplate;

    public HotelDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hotel> getHotels() {
        return jdbcTemplate
                .queryForList("""
                    select id, name, rate, price, owner, startDate, endDate 
                    from hotel
                """, Hotel.class);
    }
    @Override
    public void saveHotel() {
        jdbcTemplate.update("insert hotel values(?,?,?,?,?,?,?)");
    }

    @Override
    public void updateHotel() {
    }

    @Override
    public void deleteHotel() {

    }
}
