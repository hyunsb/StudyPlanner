package com.hyunsb.studyPlanner.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PlannerController {

    @GetMapping("/planner/home")
    public String home(Model model, HttpServletRequest request){

        if(request.getSession() != null)
            model.addAttribute("sessionValue", true);

        return "/planner/home";
    }

}
