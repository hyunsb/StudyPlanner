package com.hyunsb.studyPlanner.service;

import com.hyunsb.studyPlanner.Entity.MemberEntity;
import com.hyunsb.studyPlanner.Repository.MemberRepository;
import com.hyunsb.studyPlanner.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(MemberDTO memberDTO){
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public List<MemberEntity> findAll() {
        return memberRepository.findAll();
    }
}
