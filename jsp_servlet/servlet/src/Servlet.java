import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

// url 맵핑 (파일 이름을 그대로 노출하지 않고 해당 서블릿을 실행시킬 수 있는 url 주소 맵핑)
@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 서블릿 객체가 생성될 때 한번만 호출되는 메소드
        // 객체가 생성될 때 초기적으로 필요한 기능이 있다면 이 메소ㄷ에 구현
        // 예시 - 서블릿 페이지에 필요한 필드 선언
        System.out.println("init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 서블릿이 호출될 때마다 반복적으로 호출되는 메서드
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Servlet</title>");
        out.println("<body>");
        out.println("<main>");

        out.println("<h1>콘솔을 확인해보세요 💻</h1>");
        System.out.println("service()");

        out.println("</main>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        // 서블릿의 서비스가 종료되거나 서버 Redeploy / Restart 될 떄 호출되는 메소드
        // 서블릿의 서비스가 종료되기 전에 불필요한 자원들 (필드나 스트림 등)을 해제
        // 실질적으로 사용할 경우 거의 없음
        System.out.println("destroy()");
    }
}
