package org.example.overview.members.controller.nonlogin;

import jakarta.validation.Valid;
import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class SignupController {

    private SessionMgr sessionMgr; //= SessionMgr.getInstance();
    private CookieMgr cookieMgr; // = CookieMgr.getInstance();
    private MemberService memberService; // = MemberService.getInstance();


    @Autowired
    public SignupController(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signupPage(HttpSession session) {
        String view = "members/nonlogin/signup";

        if (session.getAttribute("SESSION_ID") != null) {
            view = "redirect:/";
        }

        return view;
    }

    @PostMapping("/signup")
    public String doSignup(@ModelAttribute @Valid MemberDTO memberDTO, BindingResult bindingResult,
                           Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        String view = signupPage(session);
        Status respStatus = Status.FAIL;

        System.out.println(memberDTO);


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error));
        }


        boolean res = memberService.signup(memberDTO.getuId(), memberDTO.getuPwStr(), memberDTO.getuEmail());
        if (res) {
            view = "redirect:/";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("signup", respStatus);
        return view;
    }

}
