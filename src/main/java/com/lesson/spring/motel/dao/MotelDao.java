package com.lesson.spring.motel.dao;

import com.lesson.spring.motel.api.response.MotelResponse;
import java.util.List;

public interface MotelDao {

    List<MotelResponse> motelList();
    void saveMotel(long price, String name);
}
