package me.servlet.login;

import me.java.cookie.CookieMgr;
import me.java.session.SessionMgr;

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

        //////////////////////// 쿠키 삭제 ////////////////////////
        cookieMgr.delete(req, resp);

        ////////////////////////// 세션 삭제 ///////////////////////
        HttpSession session = req.getSession();
        sessionMgr.delete(session);

        resp.sendRedirect("./non-login/login.jsp");
    }
}
