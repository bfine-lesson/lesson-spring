package com.lesson.spring.hotel.api;

import com.lesson.spring.hotel.api.dto.ApiRequestDto;
import com.lesson.spring.hotel.service.HotelService;
import com.lesson.spring.hotel.service.dto.HotelServiceResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HotelApiController {

    private final HotelService hotelService;

    // 호텔 전체 조회
//    @GetMapping("/hotels")
//    public String getHotels() {
//        return "";
//    }

    // 호텔 단건 조회
//    @GetMapping("/hotels/{}")
//    public String getHotel() {
//        return "";
//    }

    // 호텔 소유자 특정 날짜 이용가는 조회
    @GetMapping("/hotels/")
    public List<HotelServiceResponseDto> getHotelsWithAvailableDate(@ModelAttribute ApiRequestDto apiRequestDto) {
        apiRequestDto.getOwner();
        apiRequestDto.getAvailableDate();
        return hotelService.getHotels(apiRequestDto);
    }

    // 호텔 등록
    @PostMapping("/hotel")
    public void saveHotel() {
        hotelService.saveHotel();
    }

    // 호텔 수정
    @PatchMapping("/hotels/{}")
    public void updateHotel() {
        hotelService.updateHotel();
    }

    // 호텔 삭제
    @DeleteMapping("/hotels/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel();
    }
}
