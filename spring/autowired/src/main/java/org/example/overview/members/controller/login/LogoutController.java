package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class LogoutController { // 로그아웃 컨트롤러
    private MemberService memberService = MemberService.getInstance();

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();


    @GetMapping("/logout")
    public String doLogout(Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String view = "redirect:/";

        if (session.getAttribute("SESSION_ID") == null) {
            session.setAttribute("logout", Status.FAIL);
            return view;
        }

        cookieMgr.delete(request, response);
        sessionMgr.delete(session);

        session = request.getSession(); // 새로운 세션 생성 (새로운 세션 만들어 redirect 하기 위함)
        session.setAttribute("logout", Status.SUCCESS);

        return view;
    }
}
