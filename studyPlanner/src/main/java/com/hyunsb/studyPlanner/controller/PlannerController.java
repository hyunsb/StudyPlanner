package com.hyunsb.studyPlanner.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlannerController {

    @GetMapping("/planner/home")
    public String home(Session session){
        return "/planner/home";
    }

}
