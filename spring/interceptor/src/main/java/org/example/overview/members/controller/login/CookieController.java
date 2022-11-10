package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class CookieController { // 쿠키 컨트롤러
    private final SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private final CookieMgr cookieMgr; // = CookieMgr.getInstance();
    

    @Autowired
    public CookieController(SessionMgr sessionMgr, CookieMgr cookieMgr) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
    }

    @GetMapping("/cookies")
    public String cookiePage(Model model, HttpServletRequest request, HttpSession session) {
        String view = "members/login/cookie";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }

//        model.addAttribute("uId", sessionMgr.get(session));

        Map<String, String> cookies = new HashMap<>();
        cookies.put("JSESSIONID", cookieMgr.get(request, "JSESSIONID"));
        cookies.put("COOKIE_ID", cookieMgr.get(request, "COOKIE_ID"));
        cookies.put("AUTO_LOGIN", cookieMgr.get(request, "AUTO_LOGIN"));
        model.addAttribute("cookies", cookies);


        return view;
    }
}
