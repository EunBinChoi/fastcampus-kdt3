package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
public class LogoutController { // 로그아웃 컨트롤러

    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;


    @Autowired
    public LogoutController(SessionMgr sessionMgr, CookieMgr cookieMgr) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
    }

    @GetMapping("/logout")
    public ModelAndView doLogout(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String view = "redirect:/"; // redirect:/ => index.jsp
        ModelAndView modelAndView = new ModelAndView(view);

        cookieMgr.delete(request, response);
        sessionMgr.delete(session);

        session = request.getSession(); // 새로운 세션 생성 (새로운 세션 만들어 redirect 하기 위함)
        session.setAttribute("logout", Status.SUCCESS);

        return modelAndView; // login 끊긴 상태로 redirect
    }
}
