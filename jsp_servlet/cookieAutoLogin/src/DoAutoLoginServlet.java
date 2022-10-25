import database.MemberDatabase;
import member.Member;
import member.Password;
import util.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DoAutoLoginServlet", value = "/DoAutoLoginServlet")
public class DoAutoLoginServlet extends HttpServlet {

    static final MemberDatabase database = MemberDatabase.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String uId = "";
        String uPw = "";
        String uHashPw = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName() != null) {
                    if (cookie.getName().equals("COOKIE_ID")) {
                        uId = cookie.getValue();
                    } else if (cookie.getName().equals("COOKIE_PW")) {
                        uPw = cookie.getValue();
                    } else if (cookie.getName().equals("COOKIE_HASH_PW")) {
                        uHashPw = cookie.getValue();
                    }
                }
            }
        }
        //System.out.println("uId = " + uId); // ""
        //System.out.println("uPw = " + uPw);
        //System.out.println("uHashPw = " + uHashPw);

        // 중간에 쿠키 만료기한이 지날 수 있음
        // 중간에 쿠키 만료기한이 지나면 uId, uPw, uHashPW "" 문자열

        Member member = database.select(uId);
        if (member != null) {
            if (member.getuPw().getHashPassword().equals(uHashPw)) {
                session.setAttribute("SESSION_ID", uId);
                session.setMaxInactiveInterval(1800); // 30분


//                session.setAttribute("login", Status.SUCCESS);
                response.sendRedirect("./survey.jsp");
            } else {
//                session.setAttribute("login", Status.FAIL);
                response.sendRedirect("./login.jsp");
            }
        } else {
//            session.setAttribute("login", Status.NULL);
            response.sendRedirect("./login.jsp");
        }
    }
}
