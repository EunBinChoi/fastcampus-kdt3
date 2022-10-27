<%
    if (session.getAttribute("SESSION_ID") != null) {
        response.sendRedirect("../index.jsp");
    }

%>
