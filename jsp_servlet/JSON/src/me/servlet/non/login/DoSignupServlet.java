package me.servlet.non.login;

import me.java.member.Member;
import me.java.member.MemberDAO;
import me.java.util.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DoSignupServlet", value = "/DoSignupServlet")
public class DoSignupServlet extends HttpServlet {

    private MemberDAO memberDAO = MemberDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String uEmail = "";
        if (request.getParameter("uEmail") != null) {
            uEmail = request.getParameter("uEmail");
        }

        String uId = "";
        if (request.getParameter("uId") != null) {
            uId = request.getParameter("uId");
        }

        String uPw = "";
        if (request.getParameter("uPw") != null) {
            uPw = request.getParameter("uPw");
        }

        int result = memberDAO.insert(new Member(uId, uPw, uEmail));

        if (result > 0) {
            session.setAttribute("signup", Status.SUCCESS);
            response.sendRedirect("./non-login/login.jsp");
        } else {
            session.setAttribute("signup", Status.FAIL);
            response.sendRedirect("./non-login/signup.jsp");
        }
    }
}
