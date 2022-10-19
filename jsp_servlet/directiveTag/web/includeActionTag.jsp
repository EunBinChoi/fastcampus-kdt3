<%@ page info="Directive Tag Description Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*, member.Member" %>
<%@ page session="true" %>
<%-- 지시자 (jsp 페이지가 실행될 떄 필요한 정보를 jsp 컨테이너 (catalina)에게 알리는 역할) --%>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Title</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header><jsp:include page="header.jsp"/></header>
<main>
    <%!
        static final String CURRENT_FILE = "includeActionTag.jsp";
        static final String FOOTER_FILE = "includeFooter.jsp";
    %>
    <div><%=CURRENT_FILE%></div>
    <div><%=FOOTER_FILE%></div>
</main>
<footer><jsp:include page="includeFooter.jsp"/></footer>
</body>
</html>