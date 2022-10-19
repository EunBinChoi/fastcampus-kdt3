<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="member.Member" %>
<%@ page errorPage="error.jsp" %>
<%
  request.setCharacterEncoding("UTF-8");

  String name = "";
  if (request.getParameter("name") != null) {
    name = request.getParameter("name");
  }

  Integer age = 0;
  if (request.getParameter("age") != null) {
    age = Integer.parseInt(request.getParameter("age")); // NumberFormatException 발생 가능
  }

  Member member = new Member(name, age);
%>

<html>
<head>
  <meta charset="UTF-8">
  <title>Request</title>
  <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header><jsp:include page="header.jsp"/></header>

<main>
  <h1>RESPONSE</h1>
  <div><%=member%></div>
</main>

<footer class="main__nav__next"><jsp:include page="footer.jsp"/></footer>
</body>
</html>
