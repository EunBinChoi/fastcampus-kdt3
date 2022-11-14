package org.example.overview.members.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class SurveyController { // 개인 설정 페이지 컨트롤러


    @GetMapping("/survey")
    public String surveyPage() {
        String view = "members/login/survey";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }

    @GetMapping("/survey/res")
    public String surveyResPage() {
        String view = "members/login/surveyResult";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }


}
