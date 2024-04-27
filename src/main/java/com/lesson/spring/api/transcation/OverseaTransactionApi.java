package com.lesson.spring.api.transcation;

import com.lesson.spring.api.dto.TransactionRequestDto;
import com.lesson.spring.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/overseas/transaction")
@RequiredArgsConstructor
public class OverseaTransactionApi {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> transactStock(TransactionRequestDto transactionRequestDto){
        try {
            transactionService.transactOverseasStock(transactionRequestDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
