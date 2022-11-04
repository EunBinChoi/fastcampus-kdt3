<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*" %>
<%@ page import="org.example.overview.utils.Status" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SPRING</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header>
    <jsp:include page="../../layout/header-update.jsp"/>
</header>


<%@include file="../../messages/showMessage.jsp"%>
<%
    showMessage(request, response, "update", Status.SUCCESS);
%>


<main>
    <h1>PRIVATE PAGE</h1>
    <div>Hello! ${uId}</div>
</main>

<footer>
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>