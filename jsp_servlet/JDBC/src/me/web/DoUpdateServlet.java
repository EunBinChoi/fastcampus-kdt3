package me.web;

import me.web.cookie.CookieMgr;
import me.web.member.Member;
import me.web.member.MemberDAO;
import me.web.session.SessionMgr;
import me.web.util.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DoUpdateServlet", value = "/DoUpdateServlet")
public class DoUpdateServlet extends HttpServlet {
    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();

    private MemberDAO memberDAO = MemberDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String sessionId = "";
        if (session.getAttribute("SESSION_ID") != null) {
            sessionId = (String) session.getAttribute("SESSION_ID");
        }

        String uPw = "";
        if (request.getParameter("uPw") != null) {
            uPw = request.getParameter("uPw");
        }

        String uNewPw = "";
        if (request.getParameter("uNewPw") != null) {
            uNewPw = request.getParameter("uNewPw");
        }

        String redirectURL = request.getHeader("referer"); // 해당 서블릿을 요청한 페이지 (이전 페이지)
        Status respStatus = Status.FAIL;
        Member member = memberDAO.select(sessionId);
        if (member != null) {
            if (member.isIdPwdEquals(new Member(sessionId, uPw))) {
                int res = memberDAO.update(sessionId, uNewPw);

                if (res > 0) {
                    cookieMgr.set(request, response, "COOKIE_PW", uNewPw);

                    respStatus = Status.SUCCESS;
                    redirectURL = "./private.jsp";
                }
            }
        }
        session.setAttribute("update", respStatus);
        response.sendRedirect(redirectURL);
    }
}
