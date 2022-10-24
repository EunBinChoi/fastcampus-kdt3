<%--
  Created by IntelliJ IDEA.
  User: gennect_3
  Date: 10/19/22
  Time: 7:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Request</title>
  <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
  <jsp:include page="header.jsp"/>
</header>

<main>
  <h1>JSP</h1>
  <div>
    <form method="post" action="response.jsp">
      <div class="form__list">
        <label for="name">input your name:</label>
        <input type="text" id="name" name="name">
      </div>

      <div class="form__list">
        <label for="value">input your value: </label>
        <input type="text" id="value" name="value">
      </div>

      <input type="submit" name="submit" value="Submit">
    </form>
  </div>
</main>

<footer class="main__nav__next">
  <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
