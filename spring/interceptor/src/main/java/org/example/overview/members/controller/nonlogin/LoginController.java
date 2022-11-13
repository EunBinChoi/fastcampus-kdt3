package org.example.overview.members.controller.nonlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
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


