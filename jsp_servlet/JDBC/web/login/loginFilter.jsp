<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String uId = "";
    if (session.getAttribute("SESSION_ID") != null) {
        uId = (String) session.getAttribute("SESSION_ID");
    } else {
        response.sendRedirect("../non-login/login.jsp");
    }
%>
