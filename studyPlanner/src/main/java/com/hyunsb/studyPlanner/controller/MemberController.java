package com.hyunsb.studyPlanner.controller;

import com.hyunsb.studyPlanner.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    /* 로그인 기능 */
    @GetMapping("/member/loginform")
    public String loginForm(){
        return "/member/loginform";
    }


    /* 회원가입 기능 */
    @GetMapping("/member/createform")
    public String createForm(){
        return "/member/createform";
    }

    @PostMapping("/member/create")
    public String create(@ModelAttribute MemberDTO memberDTO){
        
    }


}
