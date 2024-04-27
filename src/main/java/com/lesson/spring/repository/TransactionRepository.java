package com.lesson.spring.repository;

import com.lesson.spring.domain.member.Member;
import com.lesson.spring.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByMemberAndStockIdIn(Member member, Set<Long> stockIds);
}
