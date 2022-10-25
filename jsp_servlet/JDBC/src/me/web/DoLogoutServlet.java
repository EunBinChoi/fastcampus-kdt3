package me.web;

import me.web.cookie.CookieMgr;
import me.web.session.SessionMgr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DoLogoutServlet", value = "/DoLogoutServlet")
public class DoLogoutServlet extends HttpServlet {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ////////////////////////// 세션 삭제 ///////////////////////
        HttpSession session = req.getSession();
        sessionMgr.delete(session);

        ///////////////// 쿠키 중 AUTO_LOGIN 값 변경 /////////////////
        cookieMgr.set(req, resp, "AUTO_LOGIN", "false");

        resp.sendRedirect("./login.jsp");
    }
}
