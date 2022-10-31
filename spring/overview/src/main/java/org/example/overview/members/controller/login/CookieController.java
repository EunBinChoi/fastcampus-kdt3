package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class CookieController { // 쿠키 컨트롤러

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();

    @GetMapping("/cookies")
    public String cookiePage(Model model, HttpServletRequest request, HttpSession session) {
        String view = "members/login/cookie";

        Map<String, String> cookies = new HashMap<>();
        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));

            cookies.put("JSESSIONID", cookieMgr.get(request, "JSESSIONID"));
            cookies.put("COOKIE_ID", cookieMgr.get(request, "COOKIE_ID"));
            cookies.put("AUTO_LOGIN", cookieMgr.get(request, "AUTO_LOGIN"));
            model.addAttribute("cookies", cookies);

        } else {
            view = "redirect:/";
        }

        return view;
    }

    @GetMapping("/cookies/{cookieName}")
    public String getCookieByName(@PathVariable String cookieName, Model model, HttpServletRequest request, HttpSession session) {
        String view = "members/login/cookie";

        Map<String, String> cookies = new HashMap<>();
        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));

            cookies.put(cookieName, cookieMgr.get(request, cookieName));
            model.addAttribute("cookies", cookies);

        } else {
            view = "redirect:/";
        }

        return view;
    }

    @PostMapping("/cookies/rm")
    public String removeCookieByName(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String[] values = null;
        if (request.getParameter("cookie") != null) {
            values = request.getParameterValues("cookie");
        }

        int count = cookieMgr.delete(request, response, values);

        if (count > 0) {
            session.setAttribute("cookie", Status.SUCCESS);
        } else {
            session.setAttribute("cookie", Status.FAIL);
        }

        return "redirect:/members/cookies";
    }
}
