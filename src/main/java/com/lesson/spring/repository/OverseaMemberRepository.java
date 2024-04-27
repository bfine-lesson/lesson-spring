package com.lesson.spring.repository;

import com.lesson.spring.domain.member.OverseasMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OverseaMemberRepository extends JpaRepository<OverseasMember, Long> {
}
