package com.lesson.spring.motel.service;

import com.lesson.spring.motel.api.request.MotelCreateRequest;
import com.lesson.spring.motel.api.response.MotelResponse;
import com.lesson.spring.motel.dao.MotelDao;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MotelService {

    private final MotelDao motelDao;

    public MotelService(MotelDao motelDao) {
        this.motelDao = motelDao;
    }

    public List<MotelResponse> getMotelList() {
        return motelDao.motelList();
    }

    public void saveMotel(MotelCreateRequest request) {
        motelDao.saveMotel(request.getPrice(), request.getName());
    }
}
