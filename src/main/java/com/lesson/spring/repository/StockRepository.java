package com.lesson.spring.repository;

import com.lesson.spring.domain.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
