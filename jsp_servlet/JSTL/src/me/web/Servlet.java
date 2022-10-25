package me.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "java.Servlet", value = "/java.Servlet")
public class Servlet extends HttpServlet {
    static final String CURRENT_FILE = Servlet.class.getName();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("\n");
        out.write("\n");
        out.write("<html>\n");
        out.write("<head>\n");
        out.write("  <title>JSP Title</title>\n");
        out.write("</head>\n");
        out.write("<body>\n");
        out.write("<main>\n");
        out.write("\n");
        out.write("<!-- html 주석 -->\n");
        out.write("<h2>Static Part</h2>\n");
        out.write("\n");
        out.write("\n");
        out.write('\n');
        out.write('\n');
        out.write('\n');
        out.write('\n');

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);

        out.write('\n');
        out.write('\n');
        out.write("\n");
        out.write("<h2>Dynamic Part: ");
        out.print(formatDateTime);
        out.write("</h2>\n");
        out.write("\n");
        out.write(' ');
        out.write('\n');
        out.write(' ');
        out.write("\n");
        out.write("\n");
        out.write("<h2>Current FIle: ");
        out.print(CURRENT_FILE);
        out.write("</h2>\n");
        out.write("\n");
        out.write("\n");
        out.write("</main>\n");
        out.write("</body>\n");
        out.write("</html>");
    }
}
