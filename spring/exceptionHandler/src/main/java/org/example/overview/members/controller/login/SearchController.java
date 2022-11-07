package org.example.overview.members.controller.login;

import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class SearchController { // 유저 검색 페이지 컨트롤러
    private SessionMgr sessionMgr; // = SessionMgr.getInstance();


    @Autowired
    public SearchController( SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/search")
    public String searchPage(Model model, HttpSession session) {

        String view = "members/login/search";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        }

        return view;
    }

}
