<%@ page import="java.util.StringTokenizer" %><%--
  Created by IntelliJ IDEA.
  User: gennect_3
  Date: 10/19/22
  Time: 7:31 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head><link rel="stylesheet" href="./css/footer.css"></head>
<footer class="footer">
    <%!
        static String FOOTER_FILE = "includeFooter.jsp";
    %>
    <%!
        public String getFooterFileName() {
            StringTokenizer stringTokenizer = new StringTokenizer(FOOTER_FILE, ".");
            return stringTokenizer.nextToken();
        }
    %>

    <div></div>
    <div><%=getFooterFileName().toUpperCase()%></div>
    <div></div>
</footer>
</html>
