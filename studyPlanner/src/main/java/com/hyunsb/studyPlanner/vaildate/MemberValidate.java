package com.hyunsb.studyPlanner.vaildate;

import com.hyunsb.studyPlanner.Repository.MemberRepository;
import com.hyunsb.studyPlanner.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

@RequiredArgsConstructor
@Validated
public class MemberValidate {

    private final MemberRepository memberRepository;

    public void nonExistentEmail(String memberEmail){
        boolean result = memberRepository.findByEmail(memberEmail).isPresent();
        if(!result)
            throw new IllegalStateException("올바른 정보를 입력해주세요.");
    }

    public void duplicateEmail(String memberEmail){
        memberRepository.findByEmail(memberEmail)
                .ifPresent(memberEntity -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }

}
