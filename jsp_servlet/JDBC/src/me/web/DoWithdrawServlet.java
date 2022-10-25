package me.web;

import me.web.cookie.CookieMgr;
import me.web.member.Member;
import me.web.session.SessionMgr;
import me.web.util.Status;
import me.web.member.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DoWithdrawServlet", value = "/DoWithdrawServlet")
public class DoWithdrawServlet extends HttpServlet {

    private SessionMgr sessionMgr = SessionMgr.getInstance();
    private CookieMgr cookieMgr = CookieMgr.getInstance();
    private MemberDAO memberDAO = MemberDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ////////////////////////// 회원 정보 삭제 ///////////////////////
        HttpSession session = req.getSession();
        String sessionId = "";
        if (session.getAttribute("SESSION_ID") != null) {
            sessionId = (String) session.getAttribute("SESSION_ID");
        }

        String requestPw = "";
        if (req.getParameter("uPw") != null) {
            requestPw = req.getParameter("uPw");
        }

        String agreement = "";
        if (req.getParameter("agree") != null) {
            agreement = req.getParameter("agree");
        }
        System.out.println("agreement = " + agreement);

        String redirectURL = resp.getHeader("referer"); // 해당 서블릿을 요청한 페이지 (이전 페이지)
        Status respStatus = Status.FAIL;
        Member member = null;
        if (agreement.equals("yes")) {
            member = memberDAO.select(sessionId); // database에 저장된 객체

            if (member != null) {
                if (member.isIdPwdEquals(new Member(sessionId, requestPw))) {
                    int res = memberDAO.delete(sessionId);

                    if (res > 0) {

                        ////////////////////////// 세션 삭제 ///////////////////////
                        sessionMgr.delete(session);

                        ///////////////////////// 쿠키 삭제 ///////////////////////
                        cookieMgr.delete(req, resp);

                        respStatus = Status.SUCCESS;
                        redirectURL = "./login.jsp";
                    }
                }
            }

        }
        session.setAttribute("withdraw", respStatus);
        resp.sendRedirect(redirectURL);
    }
}
