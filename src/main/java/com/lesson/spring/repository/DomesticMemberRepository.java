package com.lesson.spring.repository;

import com.lesson.spring.domain.member.DomesticMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomesticMemberRepository extends JpaRepository<DomesticMember, Long> {
}
