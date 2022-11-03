package org.example.overview.members.controller.nonlogin;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.WrongMemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.members.vo.MemberVO;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.example.overview.valid.GeneralValidationGroup;
import org.example.overview.valid.TestValidationGroup;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public String doSignup(@ModelAttribute @Validated(GeneralValidationGroup.class) MemberDTO memberDTO,
                           BindingResult bindingResult,
                           HttpSession session) {

        String view = signupPage(session);
        Status respStatus = Status.FAIL;


        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error));
            session.setAttribute("signup", respStatus);
            return view;
        }


        boolean res = memberService.signup(memberDTO.getuId(), memberDTO.getuPwStr(), memberDTO.getuEmail());
        if (res) {
            view = "redirect:/";
            respStatus = Status.SUCCESS;
        }

        session.setAttribute("signup", respStatus);
        return view;
    }

    @PostMapping(value = "/signup/duplicate",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Status checkDuplicateId(@RequestParam String uId) {
        if (uId == null || uId.equals("")) return Status.NULL;

        MemberDTO memberDTO = memberService.getByUserId(uId);
        Status status = Status.FAIL;

        if (memberDTO == null) {
            status = Status.SUCCESS;
        }

        return status;
    }

}
