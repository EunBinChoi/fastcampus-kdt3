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

        Password password = new Password(uPwView); // uPwView -> 암호화
        if (isCookieValue.equals("true")) {
            if (isChanged.equals("false")) {
                // new Password(password, false) // 이미 암호화가 되어있는 password
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
                        // localhost:8080/index.jsp
                        // localhost:8080/war_exploded/index.jsp
                        Cookie cookieId = new Cookie("COOKIE_ID", uId);
                        cookieId.setMaxAge(24 * 60 * 60); // 초 단위,  24 시간
                        cookieId.setPath("/"); // / 경로 이하에 모두 쿠키 전달

                        Cookie cookiePw = new Cookie("COOKIE_PW", member.getuPw().getPassword());
                        cookiePw.setMaxAge(24 * 60 * 60); // 초 단위,  24 시간
                        cookiePw.setPath("/"); // / 경로 이하에 모두 쿠키 전달

                        Cookie cookieHashPw = new Cookie("COOKIE_HASH_PW", member.getuPw().getHashPassword());
                        cookieHashPw.setMaxAge(24 * 60 * 60); // 초 단위,  24 시간
                        cookieHashPw.setPath("/"); // / 경로 이하에 모두 쿠키 전달

                        // 서버 단에서 사용자가 맞는지 확인 후 클라이언트에게 전달
                        response.addCookie(cookieId);
                        response.addCookie(cookiePw);
                        response.addCookie(cookieHashPw);
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
