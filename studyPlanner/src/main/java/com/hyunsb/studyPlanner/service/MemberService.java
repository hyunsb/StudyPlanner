package com.hyunsb.studyPlanner.service;

import com.hyunsb.studyPlanner.Entity.MemberEntity;
import com.hyunsb.studyPlanner.Repository.MemberRepository;
import com.hyunsb.studyPlanner.dto.MemberDTO;
import com.hyunsb.studyPlanner.vaildate.MemberValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private MemberValidate memberValidate;

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byEmail = memberRepository.findByEmail(memberDTO.getEmail());
        if(byEmail.isPresent()) {

            MemberEntity memberEntity = byEmail.get();

            if(memberEntity.getPassword().equals(memberDTO.getPassword())){
                return MemberDTO.toMemberDTO(memberEntity);
            }
        }

        throw new IllegalStateException("에러!");
    }

    public void save(MemberDTO memberDTO){
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
//        memberValidate.duplicateEmail(memberDTO.getEmail());
        memberRepository.save(memberEntity);
    }

    public List<MemberEntity> findAll() {
        return memberRepository.findAll();
    }


}
