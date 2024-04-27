package com.lesson.spring.domain.transaction;

import com.lesson.spring.dto.TransactionDto;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

public class Transactions {

    private final List<Transaction> transactions;

    public Transactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<TransactionDto> mergeStocks() {
        return this.transactions
                .stream()
                .map(it -> new TransactionDto(it.getStockId(), it.getQuantity(), it.getTotalPrice()))
                .collect(groupingBy(TransactionDto::getStockId, reducing(null,
                        (transactionDto1, transactionDto2) -> {
                            if (transactionDto1 == null) {
                                return transactionDto2;
                            }
                            return transactionDto1.merge(transactionDto2);
                        }))
                ).values()
                .stream()
                .toList();

    }

}