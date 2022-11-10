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
public class PrivateController { // 개인 설정 페이지 컨트롤러
    private SessionMgr sessionMgr; // = SessionMgr.getInstance();

    @Autowired
    public PrivateController(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/private")
    public String privatePage(Model model, HttpSession session) {
        String view = "members/login/private";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }

//        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }

    @GetMapping("/private/update")
    public String updatePage(Model model, HttpSession session) {
        String view = "members/login/update";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }

//        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }



    @GetMapping("/private/withdraw")
    public String withdrawPage(Model model, HttpSession session) {
        String view = "members/login/withdraw";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }

//        model.addAttribute("uId", sessionMgr.get(session));
        return view;
    }
}
