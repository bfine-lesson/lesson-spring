package com.lesson.spring.domain.member;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("O")
public class OverseasMember extends Member{

}
