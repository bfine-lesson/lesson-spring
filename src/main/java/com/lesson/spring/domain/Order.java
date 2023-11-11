package com.lesson.spring.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;

    private LocalDateTime orderDate;

    private Long totalAmounts;

    @AttributeOverrides({@AttributeOverride(column = @Column(name = "user_id"), name = "id"),
            @AttributeOverride(column = @Column(name = "user_name"), name = "name")})
    @Embedded
    private User user;

    @Embedded
    private Shipping shipping;

    @Embedded
    private Receiver receiver;


}
