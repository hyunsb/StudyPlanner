package com.hyunsb.studyPlanner.controller;

import com.hyunsb.studyPlanner.dto.MemberDTO;
import com.hyunsb.studyPlanner.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /* 로그인 기능 */
    @GetMapping("/member/loginform")
    public String MemberLoginForm(){
        return "/member/loginform";
    }

    @PostMapping("/member/login")
    public String MemberLogin(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session){
        memberService.login(memberDTO);

        model.addAttribute("message", "로그인 성공");
        model.addAttribute("searchUrl", "../planner/home");

        session.setAttribute("loginEmail", memberDTO.getEmail());

//        return "/planner/home";
        return "message";
    }

    /* 회원가입 기능 */
    @GetMapping("/member/createform")
    public String MemberCreateForm(){
        return "/member/createform";
    }

    @PostMapping("/member/create")
    public String MemberCreate(@ModelAttribute MemberDTO memberDTO, Model model){
        memberService.save(memberDTO);

        model.addAttribute("message", memberDTO.getName() + "님 회원가입이 완료 되었습니다.");
        model.addAttribute("searchUrl", "/member/loginform");

        return "message";
    }




    /*회원 조회*/
    @GetMapping("/member/list")
    public String findAll(Model model){
        model.addAttribute("memberList", memberService.findAll());
        return "/member/list";
    }


}
