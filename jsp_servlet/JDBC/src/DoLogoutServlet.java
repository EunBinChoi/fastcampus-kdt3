import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DoLogoutServlet", value = "/DoLogoutServlet")
public class DoLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ////////////////////////// 세션 삭제 ///////////////////////
        HttpSession session = req.getSession();

        if (session.getAttribute("SESSION_ID") != null) {
            session.removeAttribute("SESSION_ID");
        }
        session.invalidate(); // 세션 객체에 살고 있는 속성 값들 다 삭제 (세션 무효화)

        ////////////////////////// 쿠키 삭제 ///////////////////////
//        Cookie[] cookies = req.getCookies();
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName() != null) {
//                    if (cookie.getName().equals("COOKIE_ID")) {
//                        cookie.setMaxAge(0);
//                        cookie.setPath("/");
//                        resp.addCookie(cookie);
//                    } else if (cookie.getName().equals("COOKIE_PW")) {
//                        cookie.setMaxAge(0);
//                        cookie.setPath("/");
//                        resp.addCookie(cookie);
//                    }  else if (cookie.getName().equals("COOKIE_PW_LEN")) {
//                        cookie.setMaxAge(0);
//                        cookie.setPath("/");
//                        resp.addCookie(cookie);
//                    }
//                }
//            }
//        }
        resp.sendRedirect("./login.jsp");
    }
}
