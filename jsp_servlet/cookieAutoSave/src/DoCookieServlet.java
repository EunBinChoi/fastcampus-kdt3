import util.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DoCookieServlet", value = "/DoCookieServlet")
public class DoCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        ////////////////////////// 쿠키 삭제 ///////////////////////
        Cookie[] cookies = request.getCookies();
        String[] values = null;
        if (request.getParameter("cookie") != null) {
            values = request.getParameterValues("cookie");
        }

        int count = 0;
        for (Cookie cookie: cookies) {
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    if (cookie.getName().equals(values[i])) {
                        count++;
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
        }
        if (count > 0) {
            session.setAttribute("cookie", Status.SUCCESS);
            response.sendRedirect("./cookie.jsp");
        } else {
            session.setAttribute("cookie", Status.NULL);
            response.sendRedirect("./cookie.jsp");
        }



    }
}
