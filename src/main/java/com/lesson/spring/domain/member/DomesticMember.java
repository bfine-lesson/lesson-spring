package com.lesson.spring.domain.member;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class DomesticMember extends Member{

}
