package com.lesson.spring.motel.api;

import com.lesson.spring.motel.api.dto.MotelCreateRequest;
import com.lesson.spring.motel.api.dto.MotelResponse;
import com.lesson.spring.motel.service.MotelService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotelApi {

    private final MotelService motelService;

    public MotelApi(MotelService motelService) {
        this.motelService = motelService;
    }

    // 모텔 전체 조회
    @GetMapping("/motels")
    public List<MotelResponse> motelList() {
        return motelService.getMotelList();
    }

    // 모텔 단건 조회

    // 모텔 특정 날짜 기준 조회

    // 모텔 등록
    @PostMapping("/motel")
    public void saveMotel(@RequestBody MotelCreateRequest request) {
        motelService.saveMotel(request);
    }

    // 모텔 수정

    // 모텔 삭제

}
