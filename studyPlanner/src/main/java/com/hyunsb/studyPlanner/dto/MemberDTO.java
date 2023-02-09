package com.hyunsb.studyPlanner.dto;

import com.hyunsb.studyPlanner.Entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

    private int id;

    private String email;

    private String password;

    private String name;

    public MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setName(memberEntity.getName());
        return memberDTO;
    }

}
