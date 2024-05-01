package com.lesson.spring.service;

import com.lesson.spring.config.TestQueryDslConfig;
import com.lesson.spring.domain.cafe.CoffeeOrder;
import com.lesson.spring.domain.cafe.Customer;
import com.lesson.spring.domain.cafe.CustomerType;
import com.lesson.spring.dto.CoffeeOrderDto;
import com.lesson.spring.repository.CoffeeOrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({TestQueryDslConfig.class, CoffeeOrderService.class})
class CoffeeOrderServiceTest {

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    private static Customer male21 = new Customer(21);
    private static Customer male22 = new Customer(22);
    private static Customer male25 = new Customer(25);

    private static Customer female21 = new Customer(21);
    private static Customer female22 = new Customer(22);
    private static Customer female25 = new Customer(25);

    private static Customer kids5 = new Customer(5);
    private static Customer kids6 = new Customer(6);
    private static Customer kids7 = new Customer(7);

    @DisplayName("손님 유형별 1위 메뉴를 구한다")
    @Test
    void findTopOrderedMenu() {
        //given
        CoffeeOrder order1 = CoffeeOrder.builder().menu("아이스아메리카노").isMaleOrder(true).customer(male21).build();
        CoffeeOrder order2 = CoffeeOrder.builder().menu("카페라떼").isMaleOrder(true).customer(male22).build();
        CoffeeOrder order3 = CoffeeOrder.builder().menu("카페라뗴").isMaleOrder(true).customer(male25).build();
        CoffeeOrder order4 = CoffeeOrder.builder().menu("아이스아메리카노").isMaleOrder(true).customer(male21).build();
        CoffeeOrder order5 = CoffeeOrder.builder().menu("아이스아메리카노").isMaleOrder(true).customer(male21).build();
        CoffeeOrder order6 = CoffeeOrder.builder().menu("아이스아메리카노").isMaleOrder(true).customer(male21).build();
        CoffeeOrder order7 = CoffeeOrder.builder().menu("아이스얼그레이").isMaleOrder(true).customer(male21).build();

        CoffeeOrder order8 = CoffeeOrder.builder().menu("카페라떼").isFemaleOrder(true).customer(female21).build();
        CoffeeOrder order9 = CoffeeOrder.builder().menu("카페라떼").isFemaleOrder(true).customer(female22).build();
        CoffeeOrder order10 = CoffeeOrder.builder().menu("카페라뗴").isFemaleOrder(true).customer(female25).build();
        CoffeeOrder order11 = CoffeeOrder.builder().menu("카페모카").isFemaleOrder(true).customer(female21).build();
        CoffeeOrder order12 = CoffeeOrder.builder().menu("카페모카").isFemaleOrder(true).customer(female21).build();
        CoffeeOrder order13 = CoffeeOrder.builder().menu("카페모카").isFemaleOrder(true).customer(female21).build();
        CoffeeOrder order14 = CoffeeOrder.builder().menu("카페모카").isFemaleOrder(true).customer(female21).build();

        CoffeeOrder order15 = CoffeeOrder.builder().menu("아이스티").isKidOrder(true).customer(kids5).build();
        CoffeeOrder order16 = CoffeeOrder.builder().menu("초코칩프라포치노").isKidOrder(true).customer(kids6).build();
        CoffeeOrder order17 = CoffeeOrder.builder().menu("아이스티").isKidOrder(true).customer(kids7).build();


        coffeeOrderRepository.saveAll(List.of(order1, order2, order3, order4, order5, order6, order7, order8, order9, order10, order11, order12, order13, order14, order15, order16, order17));

        //when
        CoffeeOrderDto maleTop = coffeeOrderService.findTopOrderedMenu(CustomerType.MALE);
        CoffeeOrderDto femaleTop = coffeeOrderService.findTopOrderedMenu(CustomerType.FEMALE);
        CoffeeOrderDto kidsTop = coffeeOrderService.findTopOrderedMenu(CustomerType.KIDS);

        //then
        assertEquals(maleTop.menu(), "아이스아메리카노");
        assertEquals(femaleTop.menu(), "카페모카");
        assertEquals(kidsTop.menu(), "아이스티");
    }

}