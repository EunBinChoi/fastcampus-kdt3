<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>INDEX</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<header><jsp:include page="header.jsp"/></header>
<main>
    <h1>
        Hello world!
    </h1>
    <%
        String serverTime = (String) request.getAttribute("serverTime");
    %>
    <P> The time on the server is ${serverTime}. </P>
    <P> The time on the server is <%= serverTime %>
    </P>
</main>
<footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>
