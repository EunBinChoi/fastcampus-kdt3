import database.MemberDatabase;
import member.Member;

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

@WebServlet(name = "DoSignupServlet", value = "/DoSignupServlet")
public class DoSignupServlet extends HttpServlet {

    static final MemberDatabase database = MemberDatabase.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 회원가입 비지니스 로직 구현
        // 1) 회원가입 성공시 로그인 화면으로 돌아가기
        // 2) 회원가입 실패시 다시 signup 화면으로 돌아가기
    }
}
