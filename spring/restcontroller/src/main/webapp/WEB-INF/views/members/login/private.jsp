<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*" %>
<%@ page import="org.example.overview.utils.Status" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>


<%@include file="../../messages/showMessage.jsp"%>
<%
    showMessage(request, response, "update", Status.SUCCESS);
%>


<main>
    <h1>PRIVATE PAGE</h1>
    <div>Hello! ${uId}</div>

    <ul class="main__nav__next">
        <li><a href="/members/private/rev"><b>MEMBER INFO UPDATE</b></a></li>
        <li><a href="/members/private/rm"><b>MEMBER INFO DELETE</b></a></li>
        <li><a href="/members/cookies"><b>COOKIE</b></a></li>
    </ul>

</main>

<footer>
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>