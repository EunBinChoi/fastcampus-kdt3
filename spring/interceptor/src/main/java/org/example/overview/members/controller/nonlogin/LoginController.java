package org.example.overview.members.controller.nonlogin;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("")
public class LoginController {

    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;
    private MemberService memberService;


    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpSession session) {
        String view = "members/nonlogin/login";

//        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
//            return "redirect:/";
//        }

//        String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");
//        String cookieId = cookieMgr.get(request, "COOKIE_ID");
//
//
//        if (autoLogin != null && cookieId != null) {
//            if (memberService.autoLogin(autoLogin, cookieId)) {
//                sessionMgr.create(session, cookieId);
//                view = "redirect:/";
//            }
//        }

        return view;
    }

}


