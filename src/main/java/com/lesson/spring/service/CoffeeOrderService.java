package com.lesson.spring.service;

import com.lesson.spring.domain.cafe.CustomerType;
import com.lesson.spring.dto.CoffeeOrderDto;
import com.lesson.spring.repository.CoffeeOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoffeeOrderService {

    private final CoffeeOrderRepository coffeeOrderRepository;

    public CoffeeOrderDto findTopOrderedMenu(CustomerType customerType) {
        return new CoffeeOrderDto("코드만들어주세요");
    }
}
