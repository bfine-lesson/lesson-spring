package com.lesson.spring.service;

import com.lesson.spring.api.dto.MemberResponseDto;
import com.lesson.spring.api.dto.StockResponseDto;
import com.lesson.spring.domain.mapping.MemberStock;
import com.lesson.spring.domain.member.DomesticMember;
import com.lesson.spring.domain.member.OverseasMember;
import com.lesson.spring.domain.stock.Stock;
import com.lesson.spring.domain.transaction.Transactions;
import com.lesson.spring.dto.TransactionDto;
import com.lesson.spring.repository.DomesticMemberRepository;
import com.lesson.spring.repository.MemberStockRepository;
import com.lesson.spring.repository.OverseaMemberRepository;
import com.lesson.spring.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final DomesticMemberRepository domesticMemberRepository;
    private final OverseaMemberRepository overseaMemberRepository;
    private final MemberStockRepository memberStockRepository;
    private final TransactionRepository transactionRepository;

    public MemberResponseDto findDomesticMember(Long id) {

        DomesticMember domesticMember = domesticMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Map<Long, Stock> stocks = memberStockRepository.findAllByMember(domesticMember)
                .stream()
                .map(MemberStock::getStock)
                .collect(toMap(Stock::getId, Function.identity()));

        Transactions transactions = new Transactions(
                transactionRepository.findAllByMemberAndStockIdIn(domesticMember, stocks.keySet())
        );

        List<TransactionDto> transactionDtos = transactions.mergeStocks();

        List<StockResponseDto> stockDtos = transactionDtos.stream()
                .map(it -> {
                    Stock stock = stocks.get(it.getStockId());
                    double rate = stock.calculateRate(it.calculateAveragePrice());
                    return StockResponseDto.builder()
                            .stockId(stock.getId())
                            .companyName(stock.getCompanyName())
                            .currentPrice(stock.getCurrentPrice())
                            .averagePrice(it.calculateAveragePrice())
                            .totalPrice(it.getTotalPrice())
                            .quantity(it.getQuantity())
                            .rate(rate)
                            .build();
                })
                .collect(Collectors.toList());

        return new MemberResponseDto(
                domesticMember.getId(),
                domesticMember.getName(),
                stockDtos
        );

    }

    public MemberResponseDto findOverseasMember(Long id) {
        OverseasMember overseasMember = overseaMemberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Map<Long, Stock> stocks = memberStockRepository.findAllByMember(overseasMember)
                .stream()
                .map(MemberStock::getStock)
                .collect(toMap(Stock::getId, Function.identity()));

        Transactions transactions = new Transactions(
                transactionRepository.findAllByMemberAndStockIdIn(overseasMember, stocks.keySet())
        );

        List<TransactionDto> transactionDtos = transactions.mergeStocks();

        List<StockResponseDto> stockDtos = transactionDtos.stream()
                .map(it -> {
                    Stock stock = stocks.get(it.getStockId());
                    double rate = stock.calculateRate(it.calculateAveragePrice());
                    return StockResponseDto.builder()
                            .stockId(stock.getId())
                            .companyName(stock.getCompanyName())
                            .currentPrice(stock.getCurrentPrice())
                            .averagePrice(it.calculateAveragePrice())
                            .totalPrice(it.getTotalPrice())
                            .quantity(it.getQuantity())
                            .rate(rate)
                            .build();
                })
                .collect(Collectors.toList());

        return new MemberResponseDto(
                overseasMember.getId(),
                overseasMember.getName(),
                stockDtos
        );
    }

}
