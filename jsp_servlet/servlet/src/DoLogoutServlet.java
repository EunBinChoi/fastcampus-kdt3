import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/*
* implicitObject project 문제점
* localhost:8080/session.jsp 경로를 직접 들어가면 로그인하지 않아도 서베이 가능.
* 불가능하게 만들 수 있을까? 🫠
* */

@WebServlet(name = "DoLogoutServlet", value = "/DoLogoutServlet")
public class DoLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("uId") != null) {
            session.removeAttribute("uId");
        }
        session.invalidate(); // 세션 객체에 살고 있는 속성 값들 다 삭제 (세션 무효화)
        resp.sendRedirect("./login.jsp");
    }
}
