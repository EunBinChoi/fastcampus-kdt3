package me.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import me.web.cookie.CookieMgr;
import me.web.member.Member;
import me.web.member.MemberDAO;
import me.web.session.SessionMgr;
import me.web.util.Status;

@WebServlet(name = "DoAutoLoginServlet", value = "/DoAutoLoginServlet")
public class DoAutoLoginServlet extends HttpServlet {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private MemberDAO memberDAO = MemberDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String uId = cookieMgr.get(request, "COOKIE_ID");
        String uPw = cookieMgr.get(request, "COOKIE_PW");
        String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");


        Member member = memberDAO.select(uId);
        if (member != null) {
            if (member.getuPw().equals(uPw)) {
                sessionMgr.create(session, uId);
                response.sendRedirect("./survey.jsp");
            } else {
                session.setAttribute("login", Status.NULL);
                response.sendRedirect("./login.jsp");
            }
        } else {
            session.setAttribute("login", Status.NULL);
            response.sendRedirect("./login.jsp");
        }

    }
}
