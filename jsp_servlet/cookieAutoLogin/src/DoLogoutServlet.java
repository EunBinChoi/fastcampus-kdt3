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

        ///////////////// 기존 쿠키값 삭제할 수 있도록 변경 //////////////
        Cookie[] cookies = req.getCookies();
        String[] mustCookies = {"COOKIE_ID", "COOKIE_PW", "COOKE_HASH_PW", "AUTO_LOGIN"};

        for (int i = 0; i < mustCookies.length; i++) {
            if (cookies != null) {
                for (int j = 0; j < cookies.length; j++) {
                    if (mustCookies[i].equals(cookies[j].getName())) {
                        cookies[j].setMaxAge(0);
                        cookies[j].setPath("/");
                        resp.addCookie(cookies[j]);
                    }
                }
            }
        }


        ///////////////// 쿠키 중 AUTO_LOGIN 값 변경 /////////////////
//        Cookie[] cookies = req.getCookies();
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName() != null) {
//                    if (cookie.getName().equals("AUTO_LOGIN")) {
//                        cookie.setValue("false");
//                        resp.addCookie(cookie);
//                    }
//                }
//            }
//        }
        resp.sendRedirect("./login.jsp");
    }
}
