package org.example.overview.members.controller.nonlogin;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping("/members")
public class SignupController {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private MemberService memberService = MemberService.getInstance();


    @GetMapping("/signup")
    public String signupPage(HttpSession session) {
        String view = "members/nonlogin/signup";

        if (session.getAttribute("SESSION_ID") != null) {
            view = "redirect:/";
        }

        return view;
    }

    @PostMapping("/signup")
    public String doSignup(@RequestParam String uId, @RequestParam String uPw, @RequestParam String uEmail,
                           Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        String view = signupPage(session);
        Status respStatus = Status.FAIL;

        boolean res = memberService.signup(uId, uPw, uEmail);
        if (res) {
            view = "redirect:/";
            respStatus = Status.SUCCESS;
        }

        return view;
    }

}
