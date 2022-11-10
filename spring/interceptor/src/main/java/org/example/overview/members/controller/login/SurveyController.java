package org.example.overview.members.controller.login;

import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class SurveyController { // 개인 설정 페이지 컨트롤러

    private SessionMgr sessionMgr; // = SessionMgr.getInstance();

    @Autowired
    public SurveyController(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/survey")
    public String surveyPage(Model model, HttpSession session) {
        String view = "members/login/survey";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }

    @GetMapping("/survey/res")
    public String surveyResPage(Model model, HttpSession session) {
        String view = "members/login/surveyResult";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }


}
