package com.lesson.spring.api.transcation;

import com.lesson.spring.api.dto.MemberResponseDto;
import com.lesson.spring.api.dto.TransactionRequestDto;
import com.lesson.spring.service.MemberService;
import com.lesson.spring.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/domestic/transaction")
@RequiredArgsConstructor
public class DomesticTransactionApi {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> transactStock(@RequestBody TransactionRequestDto transactionRequestDto){
        try {
            transactionService.transactDomesticStock(transactionRequestDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
