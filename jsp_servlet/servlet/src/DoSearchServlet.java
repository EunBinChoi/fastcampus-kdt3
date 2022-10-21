import database.SearchDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;


@WebServlet(name = "DoSearchServlet", value = "/DoSearchServlet")
public class DoSearchServlet extends HttpServlet {

    static final SearchDatabase database = SearchDatabase.getInstance();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Servlet</title>");
        out.println("<body>");
        out.println("<main>");
        out.println("<h1>Search Result 📄</h1>");

        String keyword = "";
        int count = 0;
        if (request.getParameter("search") != null) {
            keyword = request.getParameter("search");

            Iterator<String> iterator = database.getData().keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Map map = database.getData().get(key);
            //    System.out.println("key = " + key);

                out.println("<ul>");

                boolean isContains = false;
                Iterator<String> mapIterator = map.keySet().iterator();
                while (mapIterator.hasNext()) {
                    String mapKey = mapIterator.next();
                    String mapVal = (String) map.get(mapKey);

                    if (mapVal.toUpperCase().contains(keyword.toUpperCase())) {
                        isContains = true;
                        count++;
                    }
                }
                if (isContains) {
                    Iterator<String> resultIterator = map.keySet().iterator();

                    while (resultIterator.hasNext()) {
                        String resultKey = resultIterator.next();
                        String resultVal = (String) map.get(resultKey);

                        if (resultKey.equals("URL")) {
                            out.println("<li><a href=\"" + resultVal + "\">링크로 이동</a>🔗</li>");
                        } else {
                            out.println("<li>" + resultKey + ": " +  "<b>" + resultVal +  "</b></li>");
                        }
                    }
                }
                out.println("</ul>");
            }

            if (count == 0) {
                out.println("<h3>We can't find anything with your keyword. 😅</h3>");
            }

        } else {
            out.println("<h3>Input search keyword.</h3>");
        }

        out.println("</main>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
    }
}
