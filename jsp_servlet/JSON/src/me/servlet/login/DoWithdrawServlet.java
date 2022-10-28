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

        String redirectURL = req.getHeader("referer"); // 해당 서블릿을 요청한 페이지 (이전 페이지)
        Status respStatus = Status.FAIL;
        Member member = null;
        if (agreement.equals("yes")) {
            member = memberDAO.select(sessionId); // database에 저장된 객체

            if (member != null) {
                if (member.getuPw().equals(requestPw)) {
                    int res = memberDAO.delete(sessionId);

                    if (res > 0) {

                        ///////////////////////// 쿠키 삭제 ///////////////////////
                        cookieMgr.delete(req, resp);

                        ////////////////////////// 세션 삭제 ///////////////////////
                        sessionMgr.delete(session);
                        session = req.getSession(); // 새로운 세션 생성 (새로운 세션 만들어 redirect 하기 위함)

                        respStatus = Status.SUCCESS;
                        redirectURL = "./non-login/login.jsp";
                    }
                }
            }

        }


        if (session != null) {
            session.setAttribute("withdraw", respStatus);
            resp.sendRedirect(redirectURL);
        }
    }
}
