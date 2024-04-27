package com.lesson.spring.domain.mapping;

import com.lesson.spring.domain.member.Member;
import com.lesson.spring.domain.stock.Stock;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public MemberStock(Member member, Stock stock) {
        this.member = member;
        this.stock = stock;
    }

}
