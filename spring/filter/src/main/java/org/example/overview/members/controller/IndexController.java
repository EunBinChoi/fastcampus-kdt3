package org.example.overview.members.controller;

import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Locale;

@Controller
public class IndexController {

    private SessionMgr sessionMgr; //= SessionMgr.getInstance();

    @Autowired
    public IndexController(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpServletRequest request) {

        LocalDateTime localDateTime = LocalDateTime.now();

        model.addAttribute("now", localDateTime);
        request.setAttribute("now", localDateTime);

//        if (session.getAttribute("SESSION_ID") != null) {
//            model.addAttribute("uId", sessionMgr.get(session));
//        }

        return "index";
    }

}
