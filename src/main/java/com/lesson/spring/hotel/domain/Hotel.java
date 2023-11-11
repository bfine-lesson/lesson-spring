/*
# 예제 - 호텔 API 만들기 (CRUD)

1. 등록
- 이름, 단계 (1~5성급), 가격, 소유자, 투숙할 수 있는 날짜구간 (시작, 끝) 포함

2. 조회
- 특정날짜 기준 특정 소유자의 해당하는 사용할 수 있는 모든 호텔 (DB 필터링 X)

3. 수정
- 가격, 소유자, 기간

4. 삭제
- 호텔 삭제

- JdbcTemplete 사용, 조회기능 테스트 코드 필수
- Response Type 은 Json, 레이어드 아키텍쳐 형태로 구현
 */

package com.lesson.spring.hotel.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Hotel {

    private Long id;
    private String name;
    private Long price;
    private String owner;
    private LocalDate startDate;
    private LocalDate endDate;

    @Builder
    public Hotel(Long id, String name, Long price, String owner, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.owner = owner;
        this.startDate = startDate; this.endDate = endDate;
    }

}
