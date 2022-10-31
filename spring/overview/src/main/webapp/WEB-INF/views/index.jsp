<%@ page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>INDEX</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<header><jsp:include page="layout/header.jsp"/></header>

<%@include file="./messages/showMessage.jsp"%>
<%
    showMessage(request, response, "logout", Status.SUCCESS);
%>

<main>
    <h1>Hello ${uId}!</h1>

    <h2>Current Time - ${now}</h2>

    <%
        LocalDateTime now = null;
        if (request.getAttribute("now") != null) {
            now = (LocalDateTime) request.getAttribute("now");
        }
    %>
    <h2>Current Time - <%=now%></h2>
</main>
<footer><jsp:include page="layout/footer.jsp"/></footer>
</body>
</html>
