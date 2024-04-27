package com.lesson.spring.api.member;

import com.lesson.spring.api.dto.MemberResponseDto;
import com.lesson.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/overseas/member")
@RequiredArgsConstructor
public class OverseasMemberApi {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public MemberResponseDto member(@PathVariable Long id){
        return memberService.findOverseasMember(id);
    }

}
