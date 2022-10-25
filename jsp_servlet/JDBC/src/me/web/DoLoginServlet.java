package me.web;

import me.web.cookie.CookieMgr;
import me.web.member.Member;
import me.web.session.SessionMgr;
import me.web.util.Status;
import me.web.member.MemberDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DoLoginServlet", value = "/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private MemberDAO memberDAO = MemberDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String uId = "";
        if (request.getParameter("uId") != null) {
            uId = request.getParameter("uId");
        }

        String uPw = "";
        if (request.getParameter("uPw") != null) {
            uPw = request.getParameter("uPw");
        }

        String save = "";
        if (request.getParameter("save") != null) {
            save = request.getParameter("save");
        }


        String redirectURL = request.getHeader("referer"); // 해당 서블릿을 요청한 페이지 (이전 페이지)
        Status respStatus = Status.FAIL;
        Member member = memberDAO.select(uId);

        if (member != null) {
            if (member.getuPw().equals(uPw)) {
                sessionMgr.create(session, uId);

                if (save != null) {
                    if (save.equals("on")) {
                        cookieMgr.create(response, new String[]{uId, uPw, "true"});
                    }
                }

                respStatus = Status.SUCCESS;
                redirectURL = "./survey.jsp";
            }
        }

        session.setAttribute("login", respStatus);
        response.sendRedirect(redirectURL);

    }
}
