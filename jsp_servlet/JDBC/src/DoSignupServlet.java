import database.MemberDatabase;
import member.Member;
import member.Password;
import util.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DoSignupServlet", value = "/DoSignupServlet")
public class DoSignupServlet extends HttpServlet {

    static final MemberDatabase database = MemberDatabase.getInstance();

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

        boolean result = database.insert(new Member(uId, new Password(uPw), uEmail));

        if (result) {
            // 1) 회원가입 성공시 로그인 화면으로 돌아가기
            session.setAttribute("signup", Status.SUCCESS);
            response.sendRedirect("./login.jsp");
        } else {
            // 2) 회원가입 실패시 다시 signup 화면으로 돌아가기
            session.setAttribute("signup", Status.FAIL);
            response.sendRedirect("./signup.jsp");
        }
    }
}
