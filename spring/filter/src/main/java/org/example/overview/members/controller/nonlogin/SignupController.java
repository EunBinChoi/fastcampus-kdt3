package org.example.overview.members.controller.nonlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class SignupController {


    @GetMapping("/signup")
    public String signupPage(HttpSession session) {
        String view = "members/nonlogin/signup";

//        if (session.getAttribute("SESSION_ID") != null) {
//            view = "redirect:/";
//        }

        return view;
    }
}
