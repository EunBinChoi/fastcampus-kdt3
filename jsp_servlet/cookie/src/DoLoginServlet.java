import member.Member;
import database.MemberDatabase;
import member.Password;
import util.Status;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DoLoginServlet", value = "/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {

    static final MemberDatabase database = MemberDatabase.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        String uId = "";
        if (request.getParameter("uId") != null) {
            uId = request.getParameter("uId");
        }

        String uPwView = "";
        if (request.getParameter("uPwView") != null) {
            uPwView = request.getParameter("uPwView");
        }


        String uHashPw = "";
        if (request.getParameter("uHashPw") != null) {
            uHashPw = request.getParameter("uHashPw");
        }


        String isCookieValue = "";
        if (request.getParameter("isCookieValue") != null) {
            isCookieValue = request.getParameter("isCookieValue");
        }

        String isChanged = "";
        if (request.getParameter("isChanged") != null) {
            isChanged = request.getParameter("isChanged");
        }

        Password password = new Password(uPwView);
        if (isCookieValue.equals("true")) {
            if (isChanged.equals("false")) {
                password = new Password(uHashPw, false);
            }
        }


//        System.out.println("uId = " + uId);
//        System.out.println("uPwView = " + uPwView);
//        System.out.println("uHashPw = " + uHashPw);
//        System.out.println("isChanged = " + isChanged);
//        System.out.println("isCookieValue = " + isCookieValue);
//        System.out.println("password = " + password);


        String save = "";
        if (request.getParameter("save") != null) {
            save = request.getParameter("save");
        }


        Member member = database.select(uId);
        System.out.println("member = " + member);
        System.out.println("======================\n\n");
        if (member != null) {
            if (member.getuPw().equals(password)) {
                session.setAttribute("SESSION_ID", uId);
                session.setMaxInactiveInterval(1800); // 30분

                if (save != null) {
                    if (save.equals("on")) {
                        Cookie cookieId = new Cookie("COOKIE_ID", uId);
                        cookieId.setMaxAge(24 * 60 * 60); // 초 단위,  24 시간
                        cookieId.setPath("/"); // / 경로 이하에 모두 쿠키 전달

                        Cookie cookiePw = new Cookie("COOKIE_PW", member.getuPw().getPassword());
                        cookiePw.setMaxAge(24 * 60 * 60); // 초 단위,  24 시간
                        cookiePw.setPath("/"); // / 경로 이하에 모두 쿠키 전달

                        Cookie cookiePwLen = new Cookie("COOKIE_HASH_PW", member.getuPw().getHashPassword());
                        cookiePwLen.setMaxAge(24 * 60 * 60); // 초 단위,  24 시간
                        cookiePwLen.setPath("/"); // / 경로 이하에 모두 쿠키 전달

                        response.addCookie(cookieId);
                        response.addCookie(cookiePw);
                        response.addCookie(cookiePwLen);
                    }
                }
                session.setAttribute("login", Status.SUCCESS);
                response.sendRedirect("./survey.jsp");
            } else {
                session.setAttribute("login", Status.FAIL);
                response.sendRedirect("./login.jsp");
            }
        } else {
            session.setAttribute("login", Status.NULL);
            response.sendRedirect("./login.jsp");
        }

    }
}
