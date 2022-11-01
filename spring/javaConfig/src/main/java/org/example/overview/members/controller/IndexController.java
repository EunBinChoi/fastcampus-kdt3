package org.example.overview.members.controller;

import org.example.overview.sessions.SessionMgr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Locale;

@Controller
public class IndexController {

    private SessionMgr sessionMgr = SessionMgr.getInstance();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Locale locale, Model model, HttpServletRequest request, HttpSession session) {

        LocalDateTime localDateTime = LocalDateTime.now();

        model.addAttribute("now", localDateTime);
        request.setAttribute("now", localDateTime);

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        }

        return "index";
    }

}
