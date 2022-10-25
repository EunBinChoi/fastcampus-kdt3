package me.web;

import me.web.cookie.CookieMgr;
import me.web.util.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DoCookieServlet", value = "/DoCookieServlet")
public class DoCookieServlet extends HttpServlet {

    private CookieMgr cookieMgr = CookieMgr.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        ////////////////////////// 쿠키 삭제 ///////////////////////
        String[] values = null;
        if (request.getParameter("cookie") != null) {
            values = request.getParameterValues("cookie");
        }

        int count = cookieMgr.delete(request, response, values);

        if (count > 0) {
            session.setAttribute("cookie", Status.SUCCESS);
        } else {
            session.setAttribute("cookie", Status.FAIL);
        }

        response.sendRedirect("./cookie.jsp");

    }
}
