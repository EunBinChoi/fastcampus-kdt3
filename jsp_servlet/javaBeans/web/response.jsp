<%--
  Created by IntelliJ IDEA.
  User: gennect_3
  Date: 10/19/22
  Time: 7:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="simple" class="simple.SimpleBeans" type="simple.SimpleBeans" scope="page"/>

<%--<jsp:setProperty name="simple" property="name" param="name"/>--%>
<%--<jsp:setProperty name="simple" property="value" param="value"/>--%>
<jsp:setProperty name="simple" property="*"/>

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
  <div>
    <p>name: <jsp:getProperty name="simple" property="name"/></p>
    <p>value: <jsp:getProperty name="simple" property="value"/></p>
  </div>
</main>

<footer class="main__nav__next"><jsp:include page="footer.jsp"/></footer>
</body>
</html>
