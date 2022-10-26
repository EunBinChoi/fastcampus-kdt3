package me.servlet.login;

import me.java.cookie.CookieMgr;
import me.java.member.Member;
import me.java.member.MemberDAO;
import me.java.session.SessionMgr;
import me.java.util.Status;

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
            if (member.getuPw().equals(uPw)) {
                int res = memberDAO.update(sessionId, uNewPw);

                if (res > 0) {
                    // cookie 에는 COOKIE_ID, AUTO_LOGIN 만 저장
                    // COOKIE_PW 는 저장할 필요 없음
                    //cookieMgr.set(request, response, "COOKIE_PW", uNewPw);

                    respStatus = Status.SUCCESS;
                    redirectURL = "./login/private.jsp";
                }
            }
        }
        session.setAttribute("update", respStatus);
        response.sendRedirect(redirectURL);
    }
}
