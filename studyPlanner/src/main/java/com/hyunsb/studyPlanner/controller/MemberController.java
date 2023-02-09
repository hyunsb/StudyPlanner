package com.hyunsb.studyPlanner.controller;

import com.hyunsb.studyPlanner.dto.MemberDTO;
import com.hyunsb.studyPlanner.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

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
    public String create(@ModelAttribute MemberDTO memberDTO, Model model){
        memberService.save(memberDTO);

        model.addAttribute("message", memberDTO.getName() + "님 회원가입이 완료 되었습니다.");
        model.addAttribute("searchUrl", "/member/loginform");

        return "/member/message";
    }







    /*회원 조회*/
    @GetMapping("/member/list")
    public String findAll(Model model){
        model.addAttribute("memberList", memberService.findAll());
        return "/member/list";
    }


}
