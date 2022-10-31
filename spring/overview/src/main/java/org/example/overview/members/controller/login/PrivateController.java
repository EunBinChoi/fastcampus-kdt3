package org.example.overview.members.controller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.dto.Password;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class PrivateController { // 개인 설정 페이지 컨트롤러
    private MemberService memberService = MemberService.getInstance();

    private SessionMgr sessionMgr = SessionMgr.getInstance();

    @GetMapping("/private")
    public String privatePage(Model model, HttpSession session) {
        String view = "members/login/private";

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        } else {
            view = "redirect:/";
        }

        return view;
    }

    @GetMapping("/private/rev")
    public String updatePage(Model model, HttpSession session) {
        String view = "members/login/update";

        String uId = "";
        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        } else {
            view = "redirect:/";
        }

        return view;
    }


    @PostMapping("/private/rev/{uId}")
    public String updateUserPassword(@PathVariable String uId, @RequestParam String uPw, @RequestParam String uNewPw,
                                     Model model, HttpSession session) {
        String view = privatePage(model, session);
        Status respStatus = Status.FAIL;

        MemberDTO memberDTO = memberService.getByUserId(uId);
        if (memberDTO == null || memberDTO.getuPwStr() == null) return view;

        if (memberDTO.getuPw().equals(Password.of(uPw, true))) {
            if (memberService.updateUserPassword(uId, Password.of(uNewPw, true))) {
                view = "redirect:/members/login/private";
                respStatus = Status.SUCCESS;
            }
        }

        return view;
    }

    @GetMapping("/private/rm")
    public String withdrawPage(Model model, HttpSession session) {
        String view = "members/login/withdraw";

        String uId = "";
        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        } else {
            view = "redirect:/";
        }

        return view;
    }


    @PostMapping("/private/rm/{uId}")
    public String removeByUserId(@PathVariable String uId, Model model, HttpSession session) {

        String view = withdrawPage(model, session);
        Status respStatus = Status.FAIL;

        boolean res = memberService.removeByUserId(uId);
        if (res) {
            respStatus = Status.SUCCESS;
        }

        return view;

    }
}
