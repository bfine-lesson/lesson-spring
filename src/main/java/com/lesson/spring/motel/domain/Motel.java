package com.lesson.spring.motel.domain;

import com.lesson.spring.hotel.domain.Rating;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "motel")
@AllArgsConstructor
@NoArgsConstructor
public class Motel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Rating rate;

    private Long price;

    private String owner;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
