package com.hyunsb.studyPlanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/member/loginform")
    public String loginForm(){
        return "/member/loginform";
    }

    @GetMapping("/member/createform")
    public String createForm(){
        return "/member/createform";
    }
}
