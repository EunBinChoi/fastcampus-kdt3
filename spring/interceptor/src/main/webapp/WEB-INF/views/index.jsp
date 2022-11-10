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
    showMessage(request, response, "withdraw", Status.SUCCESS);
    showMessage(request, response, "signup", Status.SUCCESS); // 위치 수정
%>


<main>
    <h1>${message.INDEX_MESSAGE} ${uId}!</h1>
    <h1>${message.INDEX_MESSAGE_WITH_USERID}</h1>
    <h2>${message.INDEX_TIME} - ${now}</h2>
</main>
<footer><jsp:include page="layout/footer.jsp"/></footer>
</body>
</html>
