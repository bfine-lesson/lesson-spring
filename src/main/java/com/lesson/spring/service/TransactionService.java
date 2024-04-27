package com.lesson.spring.service;

import com.lesson.spring.api.dto.TransactionRequestDto;
import com.lesson.spring.domain.mapping.MemberStock;
import com.lesson.spring.domain.member.DomesticMember;
import com.lesson.spring.domain.member.OverseasMember;
import com.lesson.spring.domain.stock.Stock;
import com.lesson.spring.domain.transaction.Transaction;
import com.lesson.spring.domain.transaction.TransactionType;
import com.lesson.spring.repository.*;
import com.lesson.spring.utils.SignUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final DomesticMemberRepository domesticMemberRepository;
    private final OverseaMemberRepository overseaMemberRepository;
    private final MemberStockRepository memberStockRepository;
    private final TransactionRepository transactionRepository;
    private final StockRepository stockRepository;

    public void transactOverseasStock(TransactionRequestDto transactionRequestDto) {
        OverseasMember overseasMember = overseaMemberRepository.findById(transactionRequestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Stock stock = stockRepository.findById(transactionRequestDto.getStockId())
                .orElseThrow(() -> new IllegalArgumentException("주식이 존재하지 않습니다."));

        TransactionType transactionType = TransactionType.valueOf(transactionRequestDto.getTransactionType());
        Transaction transaction = new Transaction(
                stock.getId(),
                transactionType,
                SignUtils.applySign(transactionType, transactionRequestDto.getRequestPrice()),
                SignUtils.applySign(transactionType, transactionRequestDto.getQuantity()),
                overseasMember
        );
        transactionRepository.save(transaction);

        MemberStock memberStock = new MemberStock(overseasMember, stock);
        if (memberStockRepository.existsByMemberAndStock(overseasMember, stock)) {
            return;
        }
        memberStockRepository.save(memberStock);
    }

    @Transactional
    public void transactDomesticStock(TransactionRequestDto transactionRequestDto) {
        DomesticMember domesticMember = domesticMemberRepository.findById(transactionRequestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Stock stock = stockRepository.findById(transactionRequestDto.getStockId())
                .orElseThrow(() -> new IllegalArgumentException("주식이 존재하지 않습니다."));

        TransactionType transactionType = TransactionType.valueOf(transactionRequestDto.getTransactionType());
        Transaction transaction = new Transaction(
                stock.getId(),
                transactionType,
                SignUtils.applySign(transactionType, transactionRequestDto.getRequestPrice()),
                SignUtils.applySign(transactionType, transactionRequestDto.getQuantity()),
                domesticMember
        );
        transactionRepository.save(transaction);
        MemberStock memberStock = new MemberStock(domesticMember, stock);
        if (memberStockRepository.existsByMemberAndStock(domesticMember, stock)) {
            return;
        }
        memberStockRepository.save(memberStock);
    }
}
