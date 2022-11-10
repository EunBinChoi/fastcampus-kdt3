package org.example.overview.members.restcontroller.login;

import exception.InputEmptyException;
import exception.InputInvalidException;
import jdk.jshell.execution.Util;
import org.example.overview.cookies.CookieMgr;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.example.overview.utils.UtilsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class CookieRestController { // 쿠키 컨트롤러
    private final SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private final CookieMgr cookieMgr; // = CookieMgr.getInstance();


    @Autowired
    public CookieRestController(SessionMgr sessionMgr, CookieMgr cookieMgr) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
    }

    @GetMapping("/cookies/{cookieName}")
    public ResponseEntity<Map<String, String>> getCookieByName(@PathVariable String cookieName,
                                                               HttpServletRequest request) {
//        String view = "members/login/cookie";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }

//        model.addAttribute("uId", sessionMgr.get(session));


        if (UtilsMethod.isNullOrEmpty(cookieName)) throw new InputEmptyException();

        Map<String, String> cookies = new HashMap<>();
        cookies.put(cookieName, cookieMgr.get(request, cookieName));
//        model.addAttribute("cookies", cookies);

        return new ResponseEntity<>(cookies, HttpStatus.OK);
    }

    @DeleteMapping("/cookies")
    public ResponseEntity<Status> removeCookieByName(@RequestBody Map<String, String> map,
                                     HttpServletRequest request, HttpServletResponse response) {
//        String view = "redirect:/members/cookies";

//        if (session.getAttribute("SESSION_ID") == null) {
//            return "redirect:/";
//        }


        if (!UtilsMethod.isNullOrEmpty(map.get("cookie1"))) cookieMgr.delete(request, response, map.get("cookie1"));
        if (!UtilsMethod.isNullOrEmpty(map.get("cookie2"))) cookieMgr.delete(request, response, map.get("cookie2"));
        if (!UtilsMethod.isNullOrEmpty(map.get("cookie3"))) cookieMgr.delete(request, response, map.get("cookie3"));


        return new ResponseEntity<>(Status.SUCCESS, HttpStatus.OK);
    }
}
