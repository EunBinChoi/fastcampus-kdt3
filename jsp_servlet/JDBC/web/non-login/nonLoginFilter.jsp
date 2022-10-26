<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("SESSION_ID") != null) {
        response.sendRedirect("../index.jsp");
    }

%>
