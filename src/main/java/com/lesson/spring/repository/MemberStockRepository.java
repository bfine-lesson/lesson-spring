package com.lesson.spring.repository;

import com.lesson.spring.domain.mapping.MemberStock;
import com.lesson.spring.domain.member.Member;
import com.lesson.spring.domain.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberStockRepository extends JpaRepository<MemberStock, Long> {

    List<MemberStock> findAllByMember(Member member);

    boolean existsByMemberAndStock(Member member, Stock stock);
}
