package com.lesson.spring.motel.dao;

import com.lesson.spring.motel.api.response.MotelResponse;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MotelDaoImpl implements MotelDao {

    private final JdbcTemplate jdbcTemplate;

    public MotelDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MotelResponse> motelList() {
        String sql = "select price, name from motel";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String name = rs.getString("name");
            long price = rs.getInt("price");
            return new MotelResponse(name, price);
        });
    }

    @Override
    public void saveMotel(long price, String name) {
        String sql = "Insert into motel (price, name)  values(?, ?)";
        jdbcTemplate.update(sql, price, name);
    }
}
