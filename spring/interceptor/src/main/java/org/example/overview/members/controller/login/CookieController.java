package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class CookieController { // 쿠키 컨트롤러
    private final SessionMgr sessionMgr;
    private final CookieMgr cookieMgr;


    @Autowired
    public CookieController(SessionMgr sessionMgr, CookieMgr cookieMgr) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
    }

    @GetMapping("/cookies")
    public ModelAndView cookiePage(HttpServletRequest request) {
        String view = "members/login/cookie";
        ModelAndView modelAndView = new ModelAndView(view);

        Map<String, String> cookies = new HashMap<>();
        cookies.put("JSESSIONID", cookieMgr.get(request, "JSESSIONID"));
        cookies.put("COOKIE_ID",  cookieMgr.get(request, "COOKIE_ID"));
        cookies.put("AUTO_LOGIN", cookieMgr.get(request, "AUTO_LOGIN"));
        modelAndView.addObject("cookies", cookies);

        return modelAndView;
    }

    @GetMapping("/cookies/{cookieName}")
    public ModelAndView getCookieByName(@PathVariable String cookieName, HttpServletRequest request) {
        String view = "members/login/cookie";
        ModelAndView modelAndView = new ModelAndView(view);

        if (UtilsMethod.isNullOrEmpty(cookieName)) return modelAndView;

        Map<String, String> cookies = new HashMap<>();
        cookies.put(cookieName, cookieMgr.get(request, cookieName));
        modelAndView.addObject("cookies", cookies);

        return modelAndView;
    }

    @PostMapping("/cookies")
    public ModelAndView removeCookieByName(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String view = "redirect:/members/cookies";
        ModelAndView modelAndView = new ModelAndView(view);

        String[] values = null;
        if (request.getParameter("cookie") != null) {
            values = request.getParameterValues("cookie");
        }

        int count = cookieMgr.delete(request, response, values);
        session.setAttribute("cookie", count > 0 ? Status.SUCCESS : Status.FAIL);

        return modelAndView;
    }
}
