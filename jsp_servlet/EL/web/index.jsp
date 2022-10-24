<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, simple.SimpleBeans"%>
<%--<%@ page isELIgnored="true"%>--%>
<%-- EL 문법 무시되고 텍스트로 출력 --%>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>


<body>
<header><jsp:include page="header.jsp"/></header>
<main>
   <div>
        <h1>JSP EL</h1>
   </div>
    <%
        // JSP 문법
        pageContext.setAttribute("msg", "at pageContext");
        request.setAttribute("msg", "at request");
        session.setAttribute("msg", "at session");
        application.setAttribute("msg", "at application");
    %>

    <%-- JSP 문법 (값이 없을 때는 null 출력) --%>
    <div>
        <p><%= pageContext.getAttribute("msg") %></p>
        <p><%= request.getAttribute("msg") %></p>
        <p><%= session.getAttribute("msg") %></p>
        <p><%= application.getAttribute("msg") %></p>
        <p><%= application.getAttribute("msg1") %></p>
    </div>

    <%-- EL 표현식 (값이 없을 때는 "" 출력)  --%>
    <div>
        <p>${pageScope.msg}</p>
        <p>${requestScope.msg}</p>
        <p>${sessionScope.msg}</p>
        <p>${applicationScope.msg}</p>
        <p>${applicationScope.msg1}</p>
    </div>

    <%-- EL 표현식 (값이 없을 때는 "" 출력)  --%>
    <%-- \ (escape 문자) 하면 해당 EL 표현식을 그냥 텍스트로 출력 --%>
    <div>
        <p>\${pageScope.msg}</p>
        <p>\${requestScope.msg}</p>
        <p>\${sessionScope.msg}</p>
        <p>\${applicationScope.msg}</p>
        <p>\${applicationScope.msg1}</p>
    </div>

    <ul class="main__nav__next">
        <li>👉🏻<a href="request.jsp"><b> Request & Response 예제로 이동</b></a></li>
        <li>👉🏻<a href="operator.jsp"><b> Operator 예제로 이동</b></a></li>
    </ul>

</main>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>